<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/jsp/common/head.jsp"%>

<div class="right">
       <div class="location">
           <strong>你现在所在的位置是:</strong>
           <span>订单管理页面</span>
       </div>
       <div class="search">
       <form method="get" action="${pageContext.request.contextPath }/user/index">
			<input name="method" value="query" class="input-text" type="hidden">
			<span>商品名称：</span>
			<input name="queryProductName" type="text" value="${queryProductName }">
			 
			<span>供应商：</span>
			<select name="queryProviderId">
				<c:if test="${providerList != null }">
				   <option value="0">--请选择--</option>
				   <c:forEach var="provider" items="${providerList}">
				   		<option
				   		value="${provider.id}">${provider.proName}</option>
				   </c:forEach>
				</c:if>
       		</select>
			 
			<span>是否付款：</span>
			<select name="queryIsPayment">
				<option value="0">--请选择--</option>
				<option value="1" ${queryIsPayment == 1 ? "selected=\"selected\"":"" }>未付款</option>
				<option value="2" ${queryIsPayment == 2 ? "selected=\"selected\"":"" }>已付款</option>
       		</select>
			
			 <input type="hidden" name="pageIndex" value="1"/>
			 <input	value="查 询" type="submit" id="searchbutton">
			 <a href="${pageContext.request.contextPath }/jsp/billadd.jsp">添加订单</a>
		</form>
       </div>
       <!--账单表格 样式和供应商公用-->
      <table class="providerTable" cellpadding="0" cellspacing="0">
          <tr class="firstTr">
              <th width="10%">订单编码</th>
              <th width="20%">商品名称</th>
              <th width="10%">供应商</th>
              <th width="10%">订单金额</th>
              <th width="10%">是否付款</th>
              <th width="10%">创建时间</th>
              <th width="30%">操作</th>
          </tr>
          <c:forEach var="bill" items="${billList }" varStatus="status">
				<tr>
					<td>
					<span>${bill.code }</span>
					</td>
					<td>
					<span>${bill.name }</span>
					</td>
					<td>
					<span>${bill.supplier}</span>
					</td>
					<td>
					<span>${bill.money}</span>
					</td>
					<td>
					<span>
						<c:if test="${bill.isPayment == 1}">未付款</c:if>
						<c:if test="${bill.isPayment == 2}">已付款</c:if>
					</span>
					</td>
					<td>
					<span>
					<fmt:formatDate value="${bill.time}" pattern="yyyy-MM-dd"/>
					</span>
					</td>
					<td>
					<span><a class="viewBill" href="javascript:;" billid=${bill.id } billcc=${bill.code }><img src="${pageContext.request.contextPath }/images/read.png" alt="查看" title="查看"/></a></span>
					<span><a class="modifyBill" href="javascript:;" billid=${bill.id } billcc=${bill.code }><img src="${pageContext.request.contextPath }/images/xiugai.png" alt="修改" title="修改"/></a></span>
					<span><a class="deleteBill" href="javascript:;" billid=${bill.id } billcc=${bill.code }><img src="${pageContext.request.contextPath }/images/schu.png" alt="删除" title="删除"/></a></span>
					</td>
				</tr>
			</c:forEach>
      </table>
      <input type="hidden" id="totalPageCount" value="${totalPageCount}"/>
		  	<c:import url="rollpage.jsp">
	          	<c:param name="totalCount" value="${totalCount}"/>
	          	<c:param name="currentPageNo" value="${currentPageNo}"/>
	          	<c:param name="totalPageCount" value="${totalPageCount}"/>
          	</c:import>
  </div>
</section>

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeBi">
    <div class="removerChid">
        <h2>提示</h2>
        <div class="removeMain">
            <p>你确定要删除该订单吗？</p>
            <a href="#" id="yes">确定</a>
            <a href="#" id="no">取消</a>
        </div>
    </div>
</div>

<%@include file="/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/billlist.js"></script>