<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set scope="application" value="${pageContext.request.contextPath}" var="root" />
<header id="header" class="header headroom">
            <!-- Fixed navbar -->
            <nav class="navbar">
                <div class="container">
                    <div class="navbar-header">
                        <a class="navbar-brand title" href="home.html">$[Social Code]</a>
                    </div>
                    <div id="navbar" class="navbar-collapse collapse">
                        <ul class="nav navbar-nav">
                            <li <% if(request.getAttribute("navColor")!=null && request.getAttribute("navColor").equals("home")){ %>
                             class="active"
                            <% } %>
                            ><a href="${root}/home"><i class="fa  fa-home"></i><span class="hidden-sm"> Home</span></a></li>
                            <li <% if(request.getAttribute("navColor")!=null && request.getAttribute("navColor").equals("profile")){ %>
                             class="active"
                            <% } %>
                            ><a href="${root}/profile"><i class="fa fa-user"></i>
                                <span class="hidden-sm"> Profile</span>
                                </a></li>
                            <li <% if(request.getAttribute("navColor")!=null && request.getAttribute("navColor").equals("code")){ %>
                             class="active"
                            <% } %>
                            >
                            <a href="${root}/code"><i class="fa fa-code"></i>
                                <span class="hidden-sm"> Code </span></a></li>
                            <li <% if(request.getAttribute("navColor")!=null && request.getAttribute("navColor").equals("tutorial")){ %>
                             class="active"
                            <% } %>
                            ><a href="${root}/newTutorial"><i class="fa fa-pencil"></i><span class="hidden-sm"> Tutorial</span></a></li>
                        </ul>
                        <form class="navbar-form navbar-left" role="search">
                            <div class="form-group">
                                <input type="text" name="q" class="form-control" placeholder="Search">
                            </div>
                        </form>
                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="${root}/account">Account</a></li>
                            <li><a href="${root}/logout">Logout</a></li>
                        </ul>
                    </div>
                    <!--/.nav-collapse -->
                </div>
            </nav>
        </header>
