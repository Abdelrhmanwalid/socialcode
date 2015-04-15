<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
	<div class="row">
		<div class="col-md-8 col-md-offset-2">
			<div style="font-size: 20px; float: right; padding: 20px;">
				<a href='<c:url value="/code/${code.id}/fork" />'><i class="fa fa-code-fork"></i> Fork</a> (0)
			</div>
			<h2 class="code-title" style="padding-left: 15px;">${code.title}</h2>
			<c:if test="${not empty code.parent}">
			<h6>forked form <a href="/code/${code.parent.id}">${code.parent.title}</a></h6>
			</c:if>
			<div class="col-md-12">

				<div>
					<pre>
						<code class="${code.language}">${code.code}</code>
					</pre>
				</div>
			</div>
		</div>
	</div>
	<div class="data col-md-8 col-md-offset-2">
		<div class="row" style="padding: 20px;">
			<div class="row">
				<label class="col-md-2">Coder</label>
				<div class="col-md-10">
					<a href="">${code.user.first_name} ${code.user.last_name}</a>
				</div>
			</div>
			<div class="row">
				<label class="col-md-2">Programming Language</label>
				<div class="col-md-10">
					<a href="">${code.language}</a>
				</div>
			</div>

		</div>
		<c:if test="${code.runnable}" >
		<div role="tabpanel">
			<!-- Nav tabs -->
			<ul class="nav nav-tabs" role="tablist">
				<li role="presentation" class="active" style="width: 50%;"><a
					style="text-align: center;" href="#input" aria-controls="input"
					role="tab" data-toggle="tab">Input</a></li>
				<li role="presentation" class="" style="width: 50%;"><a
					style="text-align: center;" href="#output" aria-controls="output"
					role="tab" data-toggle="tab">Output</a></li>
			</ul>

			<c:if test="${code.runnable}">
			<!-- Tab panes -->
			<div class="tab-content"
				style="min-height: 200px; border-right: 1px solid #DDD; border-left: 1px solid #DDD; border-bottom: 1px solid #DDD; padding: 30px;">
				<div role="tabpanel" class="tab-pane active" id="input">${code.input}</div>
				<div role="tabpanel" class="tab-pane" id="output">${code.output}</div>
			</div>
			</c:if>
		</div>
		</c:if>
	</div>
</div>