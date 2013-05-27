<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="gch" uri="/WEB-INF/tlds/gch" %>
<gch:base titulo="Listado de Laboratorios">
    <div class="informacion">
        <span>${mensaje}</span>
    </div>
    <form action="listarLaboratorios">
        <fieldset>
            <legend>Datos de B&uacute;squeda</legend>
            <div>
                <label for="nombre">
                    Nombre
                </label>
                <input type="search" name="nombre" id="nombre" maxlength="50" />
            </div>
        </fieldset>
        <button><span>Buscar</span></button>
    </form>
    <div>
        <nav>
            <ul>
                <li>
                    <a href="irRegistroLaboratorio">
                        Registrar nuevo laboratorio
                    </a>
                </li>
            </ul>
        </nav>
    </div>
    <div>
        <ul id="resultadoConsulta">
            <li class="cabeceraConsulta">
                <span>Codigo</span>
                <span>Nombre</span>
            </li>
            <c:forEach var="laboratorio" items="${requestScope.laboratorios}" >
                <li>
                    <span>${laboratorio.codigo}</span>
                    <span>${laboratorio.nombre}</span>
                </li>
            </c:forEach>
        </ul>
    </div>
</gch:base>