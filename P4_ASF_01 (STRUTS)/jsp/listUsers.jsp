<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">
  <s:include value="/jsp/components/head.jsp"></s:include>
  <body>
    <s:include value="/jsp/components/nav.jsp"></s:include>
    <div class="container">
      <div class="starter-template">
        <h1>Users</h1>
        <button type="button" class="btn btn-default btn-createuser pull-right" data-toggle="modal" data-target="#createUserModal">Create user</button>
        <div class="row">
        	<div class="col-md-12">
        		<table class="table table-striped">
				  <thead>
				  	<tr>
					  	<th>ID</th>
					  	<th>Name</th>
					  	<th>Email</th>
					  	<th>Password</th>
					  	<th>Registered</th>
					  	<th>Actions</th>
				  	</tr>
				  </thead>
				  <tbody class="usersTbody">
				  </tbody>
				</table>
        	</div>
        </div>
      </div>
    </div><!-- /.container -->
    <!-- Modal -->
	<div class="modal fade" id="createUserModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	        <form class="users-form">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" id="myModalLabel">New user</h4>
		      </div>
		      <div class="modal-body">
				  <div class="form-group">
				    <label for="name">Name</label>
				    <input type="text" class="form-control" id="name" placeholder="Name" name="name" required>
				  </div>
					<div class="form-group">
					  <label for="email">Email address</label>
					  <input type="email" class="form-control" id="email" name="email" placeholder="email" required>
					</div>
					<div class="form-group">
					  <label for="pwd">Password</label>
					  <input type="password" class="form-control" id="pwd" name="password" placeholder="Password" required>
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