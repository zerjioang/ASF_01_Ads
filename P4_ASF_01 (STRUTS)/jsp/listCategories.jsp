<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">
  <s:include value="/jsp/components/head.jsp"></s:include>
  <body>
    <s:include value="/jsp/components/nav.jsp"></s:include>
    <div class="container">
      <div class="starter-template">
        <h1>Categories</h1>
        <button type="button" class="btn btn-default btn-createcat pull-right" data-toggle="modal" data-target="#createCatModal">Create category</button>
        <div class="row">
        	<div class="col-md-12">
        		<table class="table table-striped">
				  <thead>
				  	<tr>
					  	<th>ID</th>
					  	<th>Name</th>
					  	<th>Description</th>
					  	<th>Actions</th>
				  	</tr>
				  </thead>
				  <tbody class="catsTbody">
				  </tbody>
				</table>
        	</div>
        </div>
      </div>
    </div><!-- /.container -->
    <!-- Modal -->
	<div class="modal fade" id="createCatModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	        <form class="cats-form">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" id="myModalLabel">New category</h4>
		      </div>
		      <div class="modal-body">
				  <div class="form-group">
				    <label for="name">Name</label>
				    <input type="text" class="form-control" id="name" placeholder="Name" name="name" required>
				  </div>
				  <div class="form-group">
				    <textarea class="form-control" rows="3" name="description" placeholder="Description"></textarea>
				  </div>
		      </div>
		      <input type="hidden" name="id" value=""/>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		        <button type="submit" class="btn btn-primary">Save</button>
		      </div>
			</form>
	    </div>
	  </div>
	</div>
    <s:include value="/jsp/components/scripts.jsp"></s:include>
  </body>
</html>