<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">
  <s:include value="/jsp/components/head.jsp"></s:include>
  <body>
    <s:include value="/jsp/components/nav.jsp"></s:include>
    <div class="container">
      <div class="starter-template">
        <h1>Advertisements</h1>
        <button type="button" class="btn btn-default btn-createad pull-right" data-toggle="modal" data-target="#createAdModal">Create ad</button>
        <div class="row">
        	<div class="col-md-12">
        		<table class="table table-striped">
				  <thead>
				  	<tr>
					  	<th>ID</th>
					  	<th>Name</th>
					  	<th>Description</th>
					  	<th>Price</th>
					  	<th>Actions</th>
				  	</tr>
				  </thead>
				  <tbody class="adsTbody">
				  </tbody>
				</table>
        	</div>
        </div>
      </div>
    </div><!-- /.container -->
    <!-- Modal -->
	<div class="modal fade" id="createAdModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	        <form class="ads-form">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" id="myModalLabel">New advertisement</h4>
		      </div>
		      <div class="modal-body">
				  <div class="form-group">
				    <label for="name">Name</label>
				    <input type="text" class="form-control" id="name" placeholder="Name" name="name" required>
				  </div>
				  <div class="form-group">
				    <textarea class="form-control" rows="3" name="description" placeholder="Description"></textarea>
				  </div>
					<div class="input-group">
					   <div class="input-group-addon">&euro;</div>
					   <input type="number" class="form-control" id="price" placeholder="Price" name="price" required>
					 </div>
				 <div class="form-group">
				    <label for="category">Category</label>
				    <input type="number" class="form-control" id="category" placeholder="ID" name="categoryId" required>
				  </div>
				  <div class="form-group">
				    <label for="creator">Creator</label>
				    <input type="number" class="form-control" id="creator" placeholder="ID" name="authorId" required>
				  </div>
		      </div>
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