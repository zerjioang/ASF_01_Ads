const HOST_PREFIX = 'http://localhost:8080/ASF_01_P2/rest/';
const CATEGORIES = 'categories';
const ADS = 'advertisements';
const USERS = 'users';

$(document).ready(function(){
	(function ($) {
	    $.fn.serializeFormJSON = function () {
	        var o = {};
	        var a = this.serializeArray();
	        $.each(a, function () {
	            if (o[this.name]) {
	                if (!o[this.name].push) {
	                    o[this.name] = [o[this.name]];
	                }
	                o[this.name].push(this.value || '');
	            } else {
	                o[this.name] = this.value || '';
	            }
	        });
	        return o;
	    };
	})(jQuery);
	
	function populate(frm, data) {
	  $.each(data, function(key, value){
	    $('[name='+key+']', frm).val(value);
	  });
	}
	
	function updateAds() {
		if ($(".adsTbody").length){
			$.get( "http://localhost:8080/ASF_01_P2/rest/advertisements", function( data ) {
				$(".adsTbody").empty();
	    		data.advertisement.forEach(function(item){
	    			$(".adsTbody").append('<tr><td>'+item.id+'</td><td>'+item.name+'</td><td>'+item.description+'</td><td>'+item.price+'</td><td><button class="btn btn-warning btn-updatead" data-toggle="modal" data-target="#createAdModal" data-adid='+item.id+'>Update</button> <button class="btn btn-danger btn-deletead" data-adid='+item.id+'>Delete</button></td></tr>');
	    		});
	   		}, "json" );
		}
	}
	
	function updateCats() {
		if($(".catsTbody").length) {
			$.get( 'http://localhost:8080/ASF_01_P2/rest/categories', function( data ) {
				$(".catsTbody").empty();
				data.category.forEach(function(item){
					$(".catsTbody").append('<tr><td>'+item.id+'</td><td>'+item.name+'</td><td>'+item.description+'</td><td><button class="btn btn-warning btn-updatecat" data-toggle="modal" data-target="#createCatModal" data-catid='+item.id+'>Update</button> <button class="btn btn-danger btn-deletecat" data-catid='+item.id+'>Delete</button></td></tr>');
				});
			}, "json" );
		}
	}
	
	function updateUsers() {
		if($(".usersTbody").length) {
			$.get( 'http://localhost:8080/ASF_01_P2/rest/users', function( data ) {
				$(".usersTbody").empty();
				data.user.forEach(function(item){
					$(".usersTbody").append('<tr><td>'+item.id+'</td><td>'+item.name+'</td><td>'+item.email+'</td><td>'+item.password+'</td><td>'+item.signupDate+'</td><td><button class="btn btn-warning btn-updateuser" data-toggle="modal" data-target="#createUserModal" data-userid='+item.id+'>Update</button> <button class="btn btn-danger btn-deleteuser" data-userid='+item.id+'>Delete</button></td></tr>');
				});
			}, "json" );			
		}
	}
	updateAds();
	updateCats();
	updateUsers();
	
	// ---------- DELETE -------------------
	$(document).on('click','.btn-deletead', function(event){
		var request = HOST_PREFIX+ADS+'/delete/'+$(this).data('adid');
		$.ajax({
		    url: request,
		    type: 'DELETE',
		    success: updateAds,
		    error: function(data){console.log('error: '+JSON.stringify(data))}
		  });
	});
	
	$(document).on('click','.btn-deletecat', function(event){
		var request = HOST_PREFIX+CATEGORIES+'/delete/'+$(this).data('catid');
		$.ajax({
		    url: request,
		    type: 'DELETE',
		    success: updateCats,
		    error: function(data){console.log('error: '+JSON.stringify(data))}
		  });
	});
	
	$(document).on('click','.btn-deleteuser', function(event){
		var request = HOST_PREFIX+USERS+'/delete/'+$(this).data('userid');
		$.ajax({
		    url: request,
		    type: 'DELETE',
		    success: updateUsers,
		    error: function(data){console.log('error: '+JSON.stringify(data))}
		  });
	});
	
	// ---------- CREATE/UPDATE -------------------
	$( ".ads-form" ).on( "submit", function( event ) {
	  event.preventDefault();
	  formDataJson = $(this).serializeFormJSON();
	  if (formDataJson.id === '') {
		  var request = HOST_PREFIX+ADS+'/create';
		  var requestType = 'POST';
	  } else {
		  var request = HOST_PREFIX+ADS+'/update/'+formDataJson.id;
		  var requestType = 'PUT';
	  }
	  $.ajax({
		  type: requestType,
		  url: request,
		  data: JSON.stringify(formDataJson),
		  success: function(){
			  console.log('Created successfully.');
			  if ($('.alert-danger').length) {
				  $('.alert-danger').remove();
			  }
			  updateAds();
			  document.getElementsByClassName('ads-form')[0].reset();
			  $('#createAdModal').modal('hide');
		  },
		  error: function(data){
			  if ($('.alert-danger').length) {
				  $('.alert-danger').remove();
			  }
			  $( '.modal-body' ).append( '<div class="alert alert-danger"><strong>Error</strong> Something went wrong :-/</div>' );
		  },
		  contentType: 'application/json'
		});
	});
	
	$( ".cats-form" ).on( "submit", function( event ) {
		  event.preventDefault();
		  formDataJson = $(this).serializeFormJSON();
		  
		  if (formDataJson.id === '') {
			  var request = HOST_PREFIX+CATEGORIES+'/create';
			  var requestType = 'POST';
		  } else {
			  var request = HOST_PREFIX+CATEGORIES+'/update/'+formDataJson.id;
			  var requestType = 'PUT';
		  }
		  $.ajax({
			  type: requestType,
			  url: request,
			  data: JSON.stringify(formDataJson),
			  success: function(){
				  if ($('.alert-danger').length) {
					  $('.alert-danger').remove();
				  }
				  updateCats();
				  document.getElementsByClassName('cats-form')[0].reset();
				  $('#createCatModal').modal('hide');
			  },
			  error: function(data){
				  if ($('.alert-danger').length) {
					  $('.alert-danger').remove();
				  }
				  $( '.modal-body' ).append( '<div class="alert alert-danger"><strong>Error</strong> Something went wrong :-/</div>' );
			  },
			  contentType: 'application/json'
			});
		});
	
	$( ".users-form" ).on( "submit", function( event ) {
		  event.preventDefault();
		  formDataJson = $(this).serializeFormJSON();
		  
		  if (formDataJson.id === '') {
			  var request = HOST_PREFIX+USERS+'/create';
			  var requestType = 'POST';
		  } else {
			  var request = HOST_PREFIX+USERS+'/update/'+formDataJson.id;
			  var requestType = 'PUT';
		  }
		  $.ajax({
			  type: requestType,
			  url: request,
			  data: JSON.stringify(formDataJson),
			  success: function(){
				  if ($('.alert-danger').length) {
					  $('.alert-danger').remove();
				  }
				  updateUsers();
				  document.getElementsByClassName('users-form')[0].reset();
				  $('#createUserModal').modal('hide');
			  },
			  error: function(data){
				  if ($('.alert-danger').length) {
					  $('.alert-danger').remove();
				  }
				  $( '.modal-body' ).append( '<div class="alert alert-danger"><strong>Error</strong> Something went wrong :-/</div>' );
			  },
			  contentType: 'application/json'
			});
		});
	
	// ---------- UPDATE -------------------
	$(document).on('click','.btn-updatead', function(event){
		var request = HOST_PREFIX+ADS+'/'+$(this).data('adid');
		$.ajax({
		    url: request,
		    type: 'GET',
		    dataType: 'json',
		    success: function(data){
		    	populate('.ads-form', data);
		    },
		    error: function(data){console.log('error: '+JSON.stringify(data))}
		  });
	});
	
	$(document).on('click','.btn-updatecat', function(event){
		var request = HOST_PREFIX+CATEGORIES+'/'+$(this).data('catid');
		$.ajax({
		    url: request,
		    type: 'GET',
		    dataType: 'json',
		    success: function(data){
		    	populate('.cats-form', data);
		    },
		    error: function(data){console.log('error: '+JSON.stringify(data))}
		  });
	});
	
	$(document).on('click','.btn-updateuser', function(event){
		var request = HOST_PREFIX+USERS+'/'+$(this).data('userid');
		$.ajax({
		    url: request,
		    type: 'GET',
		    dataType: 'json',
		    success: function(data){
		    	console.log(JSON.stringify(data));
		    	populate('.users-form', data);
		    },
		    error: function(data){console.log('error: '+JSON.stringify(data))}
		  });
	});
});