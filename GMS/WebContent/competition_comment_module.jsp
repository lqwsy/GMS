<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
<jsp:include page="competition_operation_tips.jsp"/>
    <div class="row collapse" id="competition-comments-module"><!-- 展开评论 -->
    	<div class="col-sm-12">
      <div class="well">
        <div class="row"><!-- 评论框 -->
            <textarea class="form-control comment-textarea" rows="5"></textarea>
        </div>
        <div class="row text-right">
            <button type="button" class="btn btn-default cancel-comment-btn">取消</button>
            <button type="button" class="btn btn-default send-comment-btn">发送</button>
        </div>
        
        <div class="row"><!--- 评论内容 -->
            <ul class="list-group comments-ul">
              <!-- <li class="list-group-item">
                <div class="row">
                    <span class="pull-left"><strong>crazylai1996</strong></span>
                    <span class="pull-right"><small>2017-05-28 00:00</small></span>
                </div>
                <div class="row">
                    <p></p>
                </div>
                <div class="row text-right">
                    <a role="button" data-toggle="collapse" href="#reply" aria-expanded="false" 
                        aria-controls="reply">
                      查看回复
                    </a>
                </div>
                
                <div class="row"> 展开回复 
                    <div class="collapse col-sm-offset-1" id="reply">
                      <div class="well">
                        <div class="row"> 回复框
                            <textarea class="form-control" rows="4"></textarea>
                        </div>
                        <div class="row text-right">
                            <button type="button" class="btn btn-default">取消</button>
                            <button type="button" class="btn btn-default">回复</button>
                        </div>
                        <div class="row"> 回复内容 
                            <ul class="list-group">
                              <li class="list-group-item">
                                <div class="row">
                                    <span class="pull-left"><strong>crazylai1996</strong></span>
                                    <span class="pull-right"><small>2017-05-28 00:00</small></span>
                                </div>
                                <div class="row">
                                    <p></p>
                                </div>
                              </li>
                            </ul>
                       </div>
                      </div>
                    </div>
                </div>
              </li> 
            </ul>-->
        </div>
      </div>
      </div>
    </div>
</body>
</html>