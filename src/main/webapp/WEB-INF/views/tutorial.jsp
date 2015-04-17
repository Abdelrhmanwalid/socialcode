<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">
	<div class="row tut-head"
		style="padding: 20px; background-color: #52C8FF; margin-top: -130px; padding-top: 130px; padding-bottom: 80px; background: url('assets/img/octicons-bg.png') repeat scroll 0% 0% #DD6B55; font-family: 'Open Sans', sans-serif;">
		<h1
			style="color: white; font-size: 50px; text-align: center; min-height: 100px; display: flex; justify-content: center; flex-direction: column;"
			class="tut-title">${tutorial.title}</h1>
	</div>
	<div class="row">
		<div class="col-md-8 col-md-offset-2 tutorial">
			${tutorial.text}
			<hr>
			<div class="row">
				<button type="button" class="btn btn-info btn-sm">CSS</button>
				<button type="button" class="btn btn-info btn-sm">Tags</button>
				<button type="button" class="btn btn-info btn-sm">JS</button>
				<button type="button" class="btn btn-info btn-sm">Code</button>
			</div>
		</div>
	</div>
	<section class="tut-user-info">
		<div class="row"
			style="background-color: #F9F9F9; padding: 30px; margin-top: 30px">
			<div class="col-md-8 col-md-offset-2">
				<div class="row">
					<div class="col-md-4" style="text-align: center;">
						<img class="img-circle" src="img/pp.jpg"
							style="height: 150px; width: 150px;"></img>
					</div>
					<div class="col-md-8">
						<h3>
							<a href="">Mohamed Mohamed</a>
						</h3>
						<p>Love coding like a ninja. C# JavaScript NodeJS and more...
						</p>
					</div>
				</div>

			</div>
		</div>
	</section>
	<section></section>
</div>