<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
{
      "statusCode":"${AJAXDON.statusCode}",
      "message":"${AJAXDON.message}",
      "navTabId":"${AJAXDON.navTabId}",
      "rel":"${AJAXDON.rel}",
      "callbackType":"${AJAXDON.callbackType}",
      "forwardUrl":"${AJAXDON.forwardUrl}",
      "confirmMsg":"${AJAXDON.confirmMsg}",
      "objData":${empty AJAXDON.objData? "null" :objData }
}
