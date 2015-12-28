<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" 
	import="org.flst.entity.User"
	import="org.flst.entity.Playlist"
	import="java.util.List"%>
 
<%@include file="layout.jsp" %>

<html>
<head>
	<title>Control page</title>
	
	<style>
		#volSlider .slider-selection {
			background: #BABABA;
		}
		#progress_bar .slider-selection {
			background: #BABABA;
		}
	</style>
	
</head>
<body>
<%
	List<Playlist>  listPlaylist 	= (List<Playlist>) request.getAttribute("listPlaylist");
	User loggedUser 				= (User) request.getAttribute("loggedUser");
	StringBuffer url = request.getRequestURL();
	String uri = request.getRequestURI();
	String ctx = request.getContextPath();
	String baseurl = url.substring(0, url.length() - uri.length() + ctx.length()) + "/";
	
%>

<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container-fluid">
      <ul class="nav navbar-nav">
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><i class="fa fa-user"></i> <%=loggedUser.getEmail()%><span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="<%=baseurl%>">Se déconnecter</a></li>
          </ul>
        </li>
      </ul>
  </div>
</nav>

<div class="container">
	
	 <div class="col-sm-5"> 
	 	<div class="col-sm-3"> 
 			SONOS :
 		</div>
 		<div class="col-sm-7"> 
		 	<select class="form-control" id="room_name">
		 	</select>
		 </div>
		<br><br><br><br><br>
	 	<div class="col-sm-2"> 
 			Playlist
 		</div>
 		
 		<div class="col-sm-5"> 
		 	<select class="form-control" id="playlist_name">	
		 	 	<%
				for (int i = 0; i < listPlaylist.size(); i++) {
				%>
					<option value="<%=(Integer) listPlaylist.get(i).getId() %>"><%=(String) listPlaylist.get(i).getName()%></option>
				<%
				}
				%>	
			</select> 	
		 </div>
		 <div class="col-sm-1"> 
		 	<button class="btn btn-primary" id="play_playlist_button" type="button"><i class="fa fa-play"></i></button>
		</div>
		 <div class="col-sm-1 col-sm-offset-1"> 
		 	<button class="btn btn-success" id="add_playlist_button" type="button" data-toggle="modal" data-target="#modal_add_playlist"><i class="fa fa-plus"></i></button>
		 </div>
		<div class="col-sm-1 col-sm-offset-1"> 
			<% if(listPlaylist.size() > 0){ %>
			<form method="post" action="deleteplaylist">
			        <input type="hidden" id="playlist_delete_id" name="playlist_delete_id" value="<%=(Integer) listPlaylist.get(0).getId()%>" />
			        <input type="hidden" id="playlist_delete_userid" name="playlist_delete_userid" value="<%=loggedUser.getId()%>" />
			        
			        <button type="submit" class="btn btn-danger" id="delete_playlist_action_button"><i class="fa fa-trash-o"></i></button>
		     </form>
		     <% } %>
		 </div>
		
		<br><br><br><br><br>
	 	<div class="col-sm-9"> 
 			<input type="text" id="say_text" class="form-control" placeholder="Texte dit par SONOS" >
 		</div>
 		<div class="col-sm-3"> 
		 	<button class="btn btn-sm btn-primary btn-block" id="say_text_button" type="button">Parler !</button>
		</div>
		 
	 </div>
	 
	 <div class="col-sm-7"> 	 
	 	 <div class="col-sm-12">
		 	 <div class="col-sm-6">
		 	 	<img id="cover" src="http://cichocki.fr/flst/projet-jee/img/default.png" height="300" width="300"> 
		 	 	<br>
		 	 	 
			 	 	 <div class="col-sm-10 input-group">
			 	 	 	<span class="input-group-btn" id="currenttimetrack_befor_progress_bar"></span>	
			 	 		<input id="progress_bar" data-slider-id="progressBarSlider" type="text" data-slider-min="0" data-slider-max="100" data-slider-step="1" data-slider-tooltip="hide"/>
			 	 		<span class="input-group-btn" id="timetrack_after_progress_bar"></span>	
			 	 	</div>
		 	 	
		 	 </div>
		 	 <br><br><br><br><br>
		 	 <div class="col-sm-2 col-sm-offset-1">
		 	 	En cours :
		 	 </div>
		 	 <div id="current_title" class="col-sm-3">
		 	 </div>
		 	 		 	 <br><br><br><br><br>
		 	 <div class="col-sm-2 col-sm-offset-1">
		 	 	A suivre :
		 	 </div>
		 	 <div id="next_title" class="col-sm-3">
		 	 </div>
	 	 </div>
	 	 
	 	 <div class="col-sm-12">
		 	 <br>
		 	 
		 	 <div class="col-sm-1">
		 	 	<button class="btn btn-sm btn-primary" id="previous_button" type="button"><i class="fa fa-fast-backward"></i></button>
		 	 </div>		 	 
		 	 <div class="col-sm-1">
		 	 	<button class="btn btn-sm btn-primary" id="playpause_button" type="button"><i class="fa fa-play"></i></button>
		 	 </div>
		 	 <div class="col-sm-1">
		 	 	<button class="btn btn-sm btn-primary" id="next_button" type="button"><i class="fa fa-fast-forward"></i></button>
		 	 </div>
		 	 <div class="col-sm-1 col-sm-offset-1">
		 	 	<button class="btn btn-sm btn-primary" id="random_button" type="button"><i class="fa fa-random"></i></button>
		 	 </div>
		 	 <div class="col-sm-1">
		 	 	<button class="btn btn-sm btn-primary" id="repeat_button" type="button"><i class="fa fa-refresh"></i></button>
		 	 </div>
		 	 <div class="col-sm-3 col-sm-offset-1">
		 	 	<div class="input-group">
				  <span class="input-group-btn">
				    <i class="fa fa-volume-down"></i>&nbsp;
				  </span>
				  <input id="volume_slider" data-slider-id="volSlider" type="text" data-slider-min="0" data-slider-max="100" data-slider-step="1" data-slider-value="30"/>
				  <span class="input-group-btn">
				    &nbsp;<i class="fa fa-volume-up"></i>
				  </span>				
				</div>
	 	 </div>
	 	 
	 	 		
		<br><br>
	 	 
	 </div>
	 
	</div>
</div> <!-- /container -->


<div class="modal fade" id="modal_add_playlist">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">Ajouter une playlist</h4>
      </div>
      <form method="post" action="addplaylist">
	      <div class="modal-body">
	        <input type="text" id="playlist_add_name" name="playlist_add_name" class="form-control" placeholder="Nom de la playlist SONOS" />
	        <input type="hidden" id="playlist_add_userid" name="playlist_add_userid" value="<%=loggedUser.getId()%>" />
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">Annuler</button>
	        <button type="submit" class="btn btn-primary" id="add_playlist_action_button">Ajouter</button>
	      </div>
      </form>
    </div>
  </div>
</div><!-- /.modal -->
	
<script>
 
var room_name  	= $( "#room_name").find('option:selected').text();

 //Definition de slider volume
 $('#volume_slider').slider().on("slide", function(slideEvt) {
		var room_name  	= $( "#room_name" ).find('option:selected').text();
		
		$.ajax({
		  method: "GET",
		  url: "http://localhost:5005/" + room_name + "/volume/" + slideEvt.value,
		});
 });
 
 //Definition de slider progress bar
 $('#progress_bar').slider();
 slideStart = false;
 $('#progress_bar').on('slideStart', function () {
     // Set a flag to indicate slide in progress
     slideStart = true;
 });
 $('#progress_bar').on('slideStop', function (slideEvt) {
	slideStart = false;
	var room_name  	= $( "#room_name" ).find('option:selected').text();
		
	$.ajax({
	  method: "GET",
	  url: "http://localhost:5005/" + room_name + "/trackseek/" + slideEvt.value,
	});
		
		//getInfoAndCover();
 });
 
 /* On recupere la liste des sonos et on rempli le select */
 var url_zones = "http://localhost:5005/zones";

 $.getJSON( url_zones
 ).done(function( data ) {
   	$.each( data, function( key, value ) {
	    	$.each(value["coordinator"], function(field_name, field_content){
	    		if(field_name === "roomName"){
	    			$('#room_name').append($('<option>', {
	    			    value: field_content,
	    			    text: field_content
	    			}));
	    		}
	      	});
   	});
   });

/*
 $.ajax({
	  url: url_zones+'/?format=jsonp',
	  dataType: 'jsonp',
	  jsonpCallback: 'parseJSON', // specify the callback name if you're hard-coding it
	  success: function(data){
	    alert("ok");
	  },
	  error: function(data){
	    alert("non");
	  },
	});
	
	*/

 /* Lecture de texte */ 
 $( ".container" ).on( "click", "#say_text_button", function() {	 	
		
		var texte 		= $( "#say_text" ).val();
		var room_name  	= $( "#room_name" ).find('option:selected').text();
			
		$.ajax({
		  method: "GET",
		  url: "http://localhost:5005/" + room_name + "/sayall/" + texte,
		});
		 
	});

 /* Lecture de la playlist */ 
 $( ".container" ).on( "click", "#play_playlist_button", function() {	 	
		
		var room_name  	= $( "#room_name" ).find('option:selected').text();
		var playlist 	= $( "#playlist_name").find('option:selected').text();
		
		$.ajax({
		  method: "GET",
		  url: "http://localhost:5005/" + room_name + "/playlist/" + playlist,
		});
		
		if($( "#playpause_button" ).html() == '<i class="fa fa-play"></i>'){
			$( "#playpause_button" ).html('<i class="fa fa-pause"></i>');
		}
		
		if($('#random_button').attr('class') == "btn btn-sm btn-info active"){
			$('#random_button').removeClass('btn-info');
			$('#random_button').removeClass('active');
			$('#random_button').addClass('btn-primary');
		}

		if($('#repeat_button').attr('class') == "btn btn-sm btn-info active"){
			$('#repeat_button').removeClass('btn-info');
			$('#repeat_button').removeClass('active');
			$('#repeat_button').addClass('btn-primary');
		}
		 
	});
	
 
 /* Play / Pause */
$( ".container" ).on( "click", "#playpause_button", function(event) {	 	
	
	var room_name  	= $( "#room_name" ).find('option:selected').text();
	var url			= "http://localhost:5005/" + room_name + "/playpause/";
		
	$.ajax({
	  method: "GET",
	  url: url,
	});
	
	if($( "#playpause_button" ).html() == '<i class="fa fa-play"></i>'){
		$( "#playpause_button" ).html('<i class="fa fa-pause"></i>');
	}
	else if ($( "#playpause_button" ).html() == '<i class="fa fa-pause"></i>'){
		$( "#playpause_button" ).html('<i class="fa fa-play"></i>');
	}
	 
});
 
 
/* Next button */ 
$( ".container" ).on( "click", "#next_button", function() {	 	

	var room_name  	= $( "#room_name" ).find('option:selected').text();
		
	$.ajax({
	  method: "GET",
	  url: "http://localhost:5005/" + room_name + "/next/",
	});
		 
});

/* Previous button */ 
$( ".container" ).on( "click", "#previous_button", function() {	 	

	var room_name  	= $( "#room_name" ).find('option:selected').text();
		
	$.ajax({
	  method: "GET",
	  url: "http://localhost:5005/" + room_name + "/previous/",
	});
		 
});

/* Repeat button */ 
$( ".container" ).on( "click", "#repeat_button", function() {	 	

	var room_name  	= $( "#room_name" ).find('option:selected').text();
	
	if($('#repeat_button').attr('class') == "btn btn-sm btn-primary"){
		$('#repeat_button').removeClass('btn-primary');
		$('#repeat_button').addClass('btn-info');
		$('#repeat_button').addClass('active');
			
		$.ajax({
		  method: "GET",
		  url: "http://localhost:5005/" + room_name + "/repeat/on/",
		});
	}
	else if($('#repeat_button').attr('class') == "btn btn-sm btn-info active"){
		$('#repeat_button').removeClass('btn-info');
		$('#repeat_button').removeClass('active');
		$('#repeat_button').addClass('btn-primary');
		
		$.ajax({
			  method: "GET",
			  url: "http://localhost:5005/" + room_name + "/repeat/off/",
			});
	}
		 
});

/* Random button */ 
$( ".container" ).on( "click", "#random_button", function() {	 	

	var room_name  	= $( "#room_name" ).find('option:selected').text();
	
	if($('#random_button').attr('class') == "btn btn-sm btn-primary"){
		$('#random_button').removeClass('btn-primary');
		$('#random_button').addClass('btn-info');
		$('#random_button').addClass('active');
			
		$.ajax({
		  method: "GET",
		  url: "http://localhost:5005/" + room_name + "/shuffle/on/",
		});
	}
	else if($('#random_button').attr('class') == "btn btn-sm btn-info active"){
		$('#random_button').removeClass('btn-info');
		$('#random_button').removeClass('active');
		$('#random_button').addClass('btn-primary');
		
		$.ajax({
			  method: "GET",
			  url: "http://localhost:5005/" + room_name + "/shuffle/off/",
			});
	}
		 
});

/* On change l'id de la plylist a supprimer quand on change la playlist dans le select */
$( ".container" ).on( "change", "#playlist_name", function() {	
	$( "#playlist_delete_id" ).val($(this).find('option:selected').val());
});


/* On recupere le "state" pour recuperer le titre, l'album ...  */
function getInfoAndCover(){

	var room  		= $( "#room_name" ).find('option:selected').text();
	var url_state	= "http://localhost:5005/"+room+"/state";

	$.getJSON( url_state)
		  .done(function( data ) {
			if (room != null && room != ""){
			  	var current_title 		= data["currentTrack"]["title"];
			  	var next_title 			= data["nextTrack"]["title"];
			  	var current_artist 		= data["currentTrack"]["artist"];
			  	var next_artist 		= data["nextTrack"]["artist"];
			  	var current_album 		= data["currentTrack"]["album"];
			  	var next_album			= data["nextTrack"]["album"];
				
			  	var duration 			= data["currentTrack"]["duration"];
			  	var elapsedTime			= data["elapsedTime"];
			  	var current_volume 		= data["volume"];
			  	var cover_url			= data["currentTrack"]["absoluteAlbumArtURI"];
	
					$('#timetrack_after_progress_bar').html("&nbsp;&nbsp;&nbsp;&nbsp;" +toHHMMSS(duration));
					$('#currenttimetrack_befor_progress_bar').html(toHHMMSS(elapsedTime) +"&nbsp;&nbsp;&nbsp;&nbsp;");
					$('#progress_bar').slider("setAttribute", 'max',  duration);
					$('#progress_bar').slider('setValue', elapsedTime);
					
					$('#volume_slider').slider('setValue', current_volume);
					/* Obtenir la cover avec la premiere image en resultat google, methode a gardée au cas où */				
					/*
			  		if(current_album != "" && current_artist != ""){
			  			// On affiche le cover de l'album
			  			var url 	= "https://ajax.googleapis.com/ajax/org.flst.jeeproject.services/search/images?v=1.0&q="+current_artist+"+"+current_album;
			  			
			  			$.ajax({
			  			   url: url,
			  			   dataType: "jsonp",
			  			   success: function(data) {
			  				   	if(data.responseData.results[0] != null){
			  				   		$('#cover').attr("src",data.responseData.results[0].tbUrl);
			  				   	}
			  			   }
			  			}); 
			  			
			  		}
					*/
					
					$('#cover').attr("src",cover_url);
		  			$('#current_title').text(current_artist + " - " + current_title);
		  			$('#next_title').text(next_artist + " - " + next_title);
			}
		   });
		   setTimeout(getInfoAndCover,1000);
		}
	
	getInfoAndCover();
  
  toHHMMSS = function (seconds) {
	  var date = new Date(seconds * 1000);
	  var hh = date.getUTCHours();
	  var mm = date.getUTCMinutes();
	  var ss = date.getSeconds();

	  if (hh < 10) {hh = "0"+hh;}
	  if (mm < 10) {mm = "0"+mm;}
	  if (ss < 10) {ss = "0"+ss;}
	  
	  if(hh == "00"){
		  var t = mm+":"+ss;
	  }
	  else{
		  var t = hh+":"+mm+":"+ss;  
	  }
	  return t;
	}
	 

</script>



</body>
</html>
