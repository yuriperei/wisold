/**
 * Yuri Pereira - Desenvolvedor
 * 24/01/2017
 */

jQuery(document).ready(function() {

	jsonAjax();

});

var jsonAjax = function(){
	
	$.ajax({
		type : "POST",
		contentType : "application/json",
		dataType : 'json',
		url : "pedido/carregar/industria.json",
		success : function(data) {
			if(data.result !== null){
				construirTabela(data);
			}else{
				$("#msgAvisoModal").text(data.msg);
				$("#avisoModal").modal("show");
			}
		},
		error : function(e) {
			$("#msgAvisoModal").text("Não foi possível carregar as Indústrias.");
			$("#avisoModal").modal("show");
		}
	});
	
};

var construirTabela = function(data) {
	var createTableRow = function(cells, id) {
		var tds = cells.map(function(cellContent) {
			return '<td>' + cellContent + '</td>';
		}).join('');
		var selecionar = '<td>' 
			+ "<a class='btn .btn-xs' href='adicionarIndustria?idIndustria="+id+"'"
			+ "id='"+id+"'>" 
			+ "<i class='fa fa-edit'></i> " 
			+ "<span class='selecionar'>Selecionar</span></a>" 
			+ '</td>';
		return '<tr>' + tds + selecionar + '</tr>';
	}

	var industrias = function(ignore, i) {
		return createTableRow([ data.result[i].nomeFantasia,
				data.result[i].razaoSocial, data.result[i].comissao ], data.result[i].id);
	};

	$('#industriaPedidoTable').append($.map(data.result, industrias));

};

// $(".selecionar").on("click", function listarIndustrias() {
//
//	myID = jQuery(this).closest("a").attr("id");
//	console.log("testando ID: " + myID);
//
//});

// <a class="btn .btn-xs" href="#"
// id="${industria.id}"> <i class="fa fa-edit"></i> <span
// class="selecionar">Selecionar</span>
// </a>
