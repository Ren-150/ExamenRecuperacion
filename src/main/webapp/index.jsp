<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css">
<link rel="stylesheet" href="recursos/css/bootstrap.min.css" />
<link rel="stylesheet" href="recursos/css/estilos.css" />
<title>Tiendita</title>
</head>
<body>
	<div class="container">
        <div id="effect" class="caja ui-widget-content ui-corner-all">
            <div id="titulo"><h4>VENTAS</h4></div>
            <div class="form-group">
                <select id="sucur" class="form-control">
                    <option value="0">Seleccionar sucursal</option>
                </select>
            </div>
            <div class="form-group">
                <select id="clien" class="form-control">
                    <option value="0">Seleccionar cliente</option>
                </select>
            </div>
            <div class="form-group">
                <input class="form-control" type="date" id="fecha" placeholder="Fecha">
            </div>
            <div class="form-group">
                <select id="tipdoc" class="form-control">
                    <option>Seleccionar tipo de documento</option>
                    <option>BOLETA</option>
                    <option>FACTURA</option>
                </select>
            </div>
            <input type="hidden" class="form-control"	id="id" value="0" />
            <div class="form-group">
                <button id="registrar" class="btn btn-primary btn-lg">Registrar</button>
            </div>
        </div>
        <table class="table" id="tablita">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Sucursal</th>
                    <th scope="col">Cliente</th>
                    <th scope="col">Fecha</th>
                    <th scope="col">Documento</th>
                    <th scope="col" colspan="2">Acción</th>
                </tr>
            </thead>
            <tbody>

            </tbody>
        </table>
    </div>
    
    <script src="recursos/js/jquery.js"></script>
	<script src="recursos/js/bootstrap.min.js"></script>
	<script src="recursos/js/venta.js"></script>
</body>
</html>