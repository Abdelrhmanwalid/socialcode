<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">
	<script type="text/javascript">
		function resizeIframe(obj) {
			obj.style.height = obj.contentWindow.document.body.scrollHeight - 5
					+ 'px';
		}
	</script>
	<div class="row">
		<div class="row tut-head"
			style="background-color: #EF7126; margin-top: -130px; padding-top: 130px; padding-bottom: 80px; background: url('assets/img/octicons-bg.png') repeat scroll 0% 0% #EF7126; font-family: 'Open Sans', sans-serif;">
			<h1
				style="color: white; font-size: 50px; text-align: center; min-height: 100px; display: flex; justify-content: center; flex-direction: column;"
				class="tut-title editable" data-disable-toolbar="true">Title</h1>
		</div>
		<div class="col-md-8 col-md-offset-2 tutorial">
			<div class="tut-container editable"
				style="min-height: 200px; margin-top: 50px;"></div>
			<hr>
		</div>

	</div>
	<div class="row" style="">
		<form:form commandName="tutorial" class="col-md-6 col-md-offset-4"
			id="tut-form">
			<form:input path="title" type="hidden" name="title"
				id="tut-title-input" />
			<form:input path="text" type="hidden" name="text"
				id="tut-container-input" />
			<label class="col-md-1 control-label" style="padding: 10px">Tags</label>
			<div class="col-sm-6">
				<input type="text" id="sel-tags" name="tags" value="" />
			</div>
			<div class="">
				<button type="submit" id="tut-submit" class="btn btn-default">Add</button>
			</div>
			<script type="text/javascript">
				window.onload = function() {

					var editor = new MediumEditor('.editable');

					$(function() {
						$('.tut-title').mediumInsert({
							editor : null,
							enabled : false
						});
						$('.tut-container')
								.mediumInsert(
										{
											editor : null,
											enabled : true,
											addons : { // (object) Addons configuration
												images : { // (object) Image addon configuration
													label : '<span class="fa fa-camera"></span>', // (string) A label for an image addon
													uploadScript : 'upload', // DEPRECATED: Use fileUploadOptions instead
													deleteScript : 'delete.php', // (string) A relative path to a delete script
													preview : true, // (boolean) Show an image before it is uploaded (only in browsers that support this feature)
													captions : true, // (boolean) Enable captions
													captionPlaceholder : 'Type caption for image (optional)', // (string) Caption placeholder
													autoGrid : 3, // (integer) Min number of images that automatically form a grid
													formData : {}, // DEPRECATED: Use fileUploadOptions instead
													fileUploadOptions : { // (object) File upload configuration. See https://github.com/blueimp/jQuery-File-Upload/wiki/Options
														url : 'upload', // (string) A relative path to an upload script
														dataType : 'json',
														acceptFileTypes : /(\.|\/)(gif|jpe?g|png)$/i
													// (regexp) Regexp of accepted file types
													},
													styles : { // (object) Available image styles configuration
														wide : { // (object) Image style configuration. Key is used as a class name added to an image, when the style is selected (.medium-insert-images-wide)
															label : '<span class="fa fa-align-justify"></span>', // (string) A label for a style
															added : function(
																	$el) {
															}, // (function) Callback function called after the style was selected. A parameter $el is a current active paragraph (.medium-insert-active)
															removed : function(
																	$el) {
															} // (function) Callback function called after a different style was selected and this one was removed. A parameter $el is a current active paragraph (.medium-insert-active)
														},
														left : {
															label : '<span class="fa fa-align-left"></span>'
														},
														right : {
															label : '<span class="fa fa-align-right"></span>'
														},
														grid : {
															label : '<span class="fa fa-th"></span>'
														}
													},
													actions : { // (object) Actions for an optional second toolbar
														remove : { // (object) Remove action configuration
															label : '<span class="fa fa-times"></span>', // (string) Label for an action
															clicked : function(
																	$el) { // (function) Callback function called when an action is selected
																var $event = $
																		.Event('keydown');

																$event.which = 8;
																$(document)
																		.trigger(
																				$event);
															}
														}
													},
													uploadCompleted : function(
															$el, data) {
													} // (function) Callback function called when upload is completed
												}
											}

										});
					});

					$('#sel-tags').selectize({
						maxItems : 5,
						persist : false,
						create : function(input) {
							return {
								value : input,
								text : input
							}
						}
					});
					$("#tut-submit").click(
							function(e) {
								e.preventDefault();
								$('.medium-insert-buttons').remove();
								$('.medium-insert-active').remove();
								$('.medium-editor-toolbar').remove();
								editor.deactivate();
								$('#tut-title-input').val(
										editor.elements[0].innerHTML);
								$('#tut-container-input').val(
										editor.elements[1].innerHTML);
								$("#tut-form").unbind('submit').submit();
								return true;
							});
				};
			</script>
		</form:form>
	</div>
</div>