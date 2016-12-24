<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">
  <s:include value="/jsp/components/head.jsp"></s:include>
  <body>
    <s:include value="/jsp/components/nav.jsp"></s:include>
    <div class="container">
      <div class="starter-template">
        <h1>List of ads</h1>
        <div class="row">
        	<div class="col-md-12">
        		<table class="table table-striped">
				  <thead>
				  	<tr>
					  	<th>ID</th>
					  	<th>Name</th>
					  	<th>Description</th>
					  	<th>Price</th>
				  	</tr>
				  </thead>
				  <tbody class="adsTbody">
				  </tbody>
				</table>
        	</div>
        </div>
      </div>
    </div><!-- /.container -->
    <s:include value="/jsp/components/scripts.jsp"></s:include>
    <script>
    $(document).ready(function(){
    	$.get( "http://localhost:8080/ASF_01_P2/rest/advertisements", function( data ) {
    		data.advertisement.forEach(function(item){
    			$(".adsTbody").append("<tr><td>"+item.id+"</td><td>"+item.name+"</td><td>"+item.description+"</td><td>"+item.price+"</td></tr>");
    		});
   		  alert( "Load was performed." );
   		}, "json" );
    });
    </script>
  </body>
</html>