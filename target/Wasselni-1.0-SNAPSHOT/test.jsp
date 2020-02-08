<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 03/02/2020
  Time: 21:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${sessionScope.depart}--
${sessionScope.destination}--
${sessionScope.dateTrajet}--
${sessionScope.heureDepart}--
${sessionScope.minutesDepart}--
${sessionScope.effectif}--
${sessionScope.prix}--
${sessionScope.bagageAutorisé}--
${sessionScope.typeVehicule}--
${sessionScope.marque}--
${sessionScope.model}--
${sessionScope.climatisation}
${sessionScope.userSession.login}--
${sessionScope.userId}--
${sessionScope.userSession.activation}

${sessionScope.details.typeVoiture}
${sessionScope.details.effectif}
${sessionScope.details.climatisationVoiture}
${sessionScope.details.dateDepart}
${sessionScope.details.modeleVoiture}
${sessionScope.details.marqueVoiture}
${sessionScope.details.prixPlace}

${offres}



</body>
</html>
