$(document).ready(function(){
	listar();
	listar2();
	listar3();
	limpiar();
	
});

function listar2(){
	$.get("sc", {"opc":1}, function(data){
		var x= JSON.parse(data);
		$("#sucur tbody tr").remove();
		for(var i=0;i<x.length;i++){
			$("#sucur").append("<option value='"+x[i].idsucursal+"'>"+x[i].nomsucursal+"</option>");
		}
	});
}

function listar3(){
	$.get("cc", {"opc":1}, function(data){
		var x= JSON.parse(data);
		$("#clien tbody tr").remove();
		for(var i=0;i<x.length;i++){
			$("#clien").append("<option value='"+x[i].idcliente+"'>"+x[i].nombres+"</option>");
		}
	});
}

function listar(){
	$.get("vc", {"opc":1}, function(data){
		var x= JSON.parse(data);
		$("#tablita tbody tr").remove();
		for(var i=0;i<x.length;i++){
			$("#tablita").append("<tr><td>"+(i+1)+"</td><td>"+x[i].sucursal+"</td><td>"+x[i].cliente+"</td><td>"+x[i].fecha+"</td><td>"+x[i].tipodoc+"</td><td><a href='#' onclick='editar("+x[i].idventa+")'><i class='fa fa-pencil-square-o' aria-hidden='true'></i></i></a></td><td><a href='#' onclick='eliminar("+x[i].idventa+")'><i class='fa fa-trash' aria-hidden='true'></i></a></td></tr>");
		}
	});
}

$("#registrar").click(function(){
	var idr = $("#id").val();
	if(idr==0){
	var param = {"fecha":$("#fecha").val(), "tipodoc":$("#tipdoc").val(), "idsucursal":$("#sucur").val(), "idcliente":$("#clien").val(), "opc":2};	$.ajax({
		beforeSend: function(){
			alert("ENTRO");
		},
		data: param,
		url: 'vc',
		type: 'POST',
		success: function(response){
			alert(response);
			limpiar();
			listar();
		},
		error: function(jqXHR, estado, error){
		console.log(estado)
		console.log(error)
		},
		complete: function (jqXHR, estado){
			console.log(estado)
		}		
	});
	}else{
		$.post("vc",{"fecha":$("#fecha").val(), "tipodoc":$("#tipdoc").val(), "idsucursal":$("#sucur").val(), "idcliente":$("#clien").val(), "opc":4},function (data) {
		listar();
		limpiar();
    });
	}
});

function editar(id){
	$("#registrar").html("Editar");
	$.get("vc",{"id":id,"opc":3},function (data) {
		var x = JSON.parse(data);
		$("#id").val(x.idventa)
		$("#fecha").val(x.fecha)
		$("#tipdoc").val(x.tipodoc)
		$("#sucur").val(x.idsucursal)
		$("#clien").val(x.idcliente);
    });
}



function eliminar(id){
	$.get("vc",{"id":id,"opc":5},function () {
        listar();
    });
}


function limpiar(){
	$("#id").val(0);
	$("#fecha").val("");
	$("#tipdoc").val("");
	$("#sucur").val("");
	$("#clien").val("");
	$("#sucur").focus();
	$("#registrar").html("Registrar");
}