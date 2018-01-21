
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8"/>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Java实现验证码的制作 - 夜已殇 - 博客园</title>
<link type="text/css" rel="stylesheet" href="/bundles/blog-common.css?v=ON3Mxdo4-HlSMqbNDBZXhFIcGLon3eZDvU8zBESgwkk1"/>
<link id="MainCss" type="text/css" rel="stylesheet" href="/skins/darkgreentrip/bundle-darkgreentrip.css?v=xPXJVC4GCITs1yYYgSeLkcicCxapqseaPVQLFGMO1wc1"/>
<link id="mobile-style" media="only screen and (max-width: 767px)" type="text/css" rel="stylesheet" href="/skins/darkgreentrip/bundle-darkgreentrip-mobile.css?v=6NcJHqsIyaE4w19VtgFvCFahrnr2rYCTRRTdxlMDhhQ1"/>
<link title="RSS" type="application/rss+xml" rel="alternate" href="http://www.cnblogs.com/happyfans/rss"/>
<link title="RSD" type="application/rsd+xml" rel="EditURI" href="http://www.cnblogs.com/happyfans/rsd.xml"/>
<link type="application/wlwmanifest+xml" rel="wlwmanifest" href="http://www.cnblogs.com/happyfans/wlwmanifest.xml"/>
<script src="//common.cnblogs.com/scripts/jquery-2.2.0.min.js"></script>
<script type="text/javascript">var currentBlogApp = 'happyfans', cb_enable_mathjax=true;var isLogined=true;</script>
<script type="text/x-mathjax-config">
    MathJax.Hub.Config({
        tex2jax: { inlineMath: [['$','$'], ['\\(','\\)']], processClass: 'blogpost-body', processEscapes: true },
        TeX: { 
            equationNumbers: { autoNumber: ['AMS'], useLabelIds: true }, extensions: ['extpfeil.js'] },
            'HTML-CSS': { linebreaks: { automatic: true } },
            SVG: { linebreaks: { automatic: true } }
        });
    </script><script src="//mathjax.cnblogs.com/2_7_2/MathJax.js?config=TeX-AMS-MML_HTMLorMML"></script>
<script src="/bundles/blog-common.js?v=O-NTEmnhjbG7lSYLc3yeqkrVxfMJyY9iXf4xyjlKikw1" type="text/javascript"></script>
</head>
<body>
<a name="top"></a>

<!--done-->
<div id="home">
<div id="header">
	<div id="blogTitle">
	<a id="lnkBlogLogo" href="http://www.cnblogs.com/happyfans/"><img id="blogLogo" src="/Skins/custom/images/logo.gif" alt="返回主页" /></a>			
		
<!--done-->
<h1><a id="Header1_HeaderTitle" class="headermaintitle" href="http://www.cnblogs.com/happyfans/">夜已殇</a></h1>
<h2></h2>



		
	</div><!--end: blogTitle 博客的标题和副标题 -->
	<div id="navigator">
		
<ul id="navList">
<li><a id="blog_nav_sitehome" class="menu" href="http://www.cnblogs.com/">博客园</a></li>
<li><a id="blog_nav_myhome" class="menu" href="http://www.cnblogs.com/happyfans/">首页</a></li>
<li><a id="blog_nav_newpost" class="menu" rel="nofollow" href="https://i.cnblogs.com/EditPosts.aspx?opt=1">新随笔</a></li>
<li><a id="blog_nav_contact" class="menu" rel="nofollow" href="https://msg.cnblogs.com/send/%E5%A4%9C%E5%B7%B2%E6%AE%87">联系</a></li>
<li><a id="blog_nav_rss" class="menu" href="http://www.cnblogs.com/happyfans/rss">订阅</a>
<!--<a id="blog_nav_rss_image" class="aHeaderXML" href="http://www.cnblogs.com/happyfans/rss"><img src="//www.cnblogs.com/images/xml.gif" alt="订阅" /></a>--></li>
<li><a id="blog_nav_admin" class="menu" rel="nofollow" href="https://i.cnblogs.com/">管理</a></li>
</ul>
		<div class="blogStats">
			
			<div id="blog_stats">
<span id="stats_post_count">随笔 - 22&nbsp; </span>
<span id="stats_article_count">文章 - 1&nbsp; </span>
<span id="stats-comment_count">评论 - 5</span>
</div>
			
		</div><!--end: blogStats -->
	</div><!--end: navigator 博客导航栏 -->
</div><!--end: header 头部 -->

<div id="main">
	<div id="mainContent">
	<div class="forFlow">
		
<div id="post_detail">
<!--done-->
<div id="topics">
	<div class = "post">
		<h1 class = "postTitle">
			<a id="cb_post_title_url" class="postTitle2" href="http://www.cnblogs.com/happyfans/p/4486010.html">Java实现验证码的制作</a>
		</h1>
		<div class="clear"></div>
		<div class="postBody">
			<div id="cnblogs_post_body" class="blogpost-body"><h1>验证码概述</h1>
<h2>为什么使用验证码？</h2>
<p>　　验证码（CAPTCHA）是一种全自动程序。主要是为了区分&ldquo;进行操作的是不是人&rdquo;。如果没有验证码机制，将会导致以下的问题:</p>
<ul>
<li>对特定网站不断进行登录，破解密码；</li>
<li>对某个网站创建账户；</li>
<li>对某个网站提交垃圾数据（灌水贴）；</li>
<li>对某个网站进行刷票。</li>
</ul>
<p>&nbsp;</p>
<h2>使用Servlet实现验证码</h2>
<p>　　一个验证码包含两个部分：图片和输入框。</p>
<div class="cnblogs_code">
<pre><span style="color: #008080;"> 1</span> <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">script </span><span style="color: #ff0000;">type</span><span style="color: #0000ff;">="text/javascript"</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 2</span>     <span style="background-color: #f5f5f5; color: #0000ff;">function</span><span style="background-color: #f5f5f5; color: #000000;"> reloadCode(){
</span><span style="color: #008080;"> 3</span>         <span style="background-color: #f5f5f5; color: #0000ff;">var</span><span style="background-color: #f5f5f5; color: #000000;"> time </span><span style="background-color: #f5f5f5; color: #000000;">=</span> <span style="background-color: #f5f5f5; color: #0000ff;">new</span><span style="background-color: #f5f5f5; color: #000000;"> Date();
</span><span style="color: #008080;"> 4</span>         <span style="background-color: #f5f5f5; color: #008000;">//</span><span style="background-color: #f5f5f5; color: #008000;"> 给URL传递参数可以清空浏览器的缓存，让浏览器认为这是一个新的请求</span>
<span style="color: #008080;"> 5</span> <span style="background-color: #f5f5f5; color: #000000;">        document.getElementById(</span><span style="background-color: #f5f5f5; color: #000000;">'</span><span style="background-color: #f5f5f5; color: #000000;">safecode</span><span style="background-color: #f5f5f5; color: #000000;">'</span><span style="background-color: #f5f5f5; color: #000000;">).src </span><span style="background-color: #f5f5f5; color: #000000;">=</span> <span style="background-color: #f5f5f5; color: #000000;">'</span><span style="background-color: #f5f5f5; color: #000000;">&lt;%=request.getContextPath()%&gt;/servlet/ImageServlet?d=</span><span style="background-color: #f5f5f5; color: #000000;">'</span> <span style="background-color: #f5f5f5; color: #000000;">+</span><span style="background-color: #f5f5f5; color: #000000;"> time;
</span><span style="color: #008080;"> 6</span> <span style="background-color: #f5f5f5; color: #000000;">    }
</span><span style="color: #008080;"> 7</span> <span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">script</span><span style="color: #0000ff;">&gt;</span>    
<span style="color: #008080;"> 8</span> 
<span style="color: #008080;"> 9</span> <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">form </span><span style="color: #ff0000;">action</span><span style="color: #0000ff;">="&lt;%=request.getContextPath()%&gt;/servlet/ValidateImageServlet"</span><span style="color: #ff0000;">method</span><span style="color: #0000ff;">="post"</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;">10</span>         验证码：<span style="color: #0000ff;">&lt;</span><span style="color: #800000;">img </span><span style="color: #ff0000;">src</span><span style="color: #0000ff;">="&lt;%=request.getContextPath()%&gt;/servlet/ImageServlet"</span><span style="color: #ff0000;"> alt</span><span style="color: #0000ff;">="验证码"</span><span style="color: #ff0000;"> id</span><span style="color: #0000ff;">="safecode"</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;">11</span>     <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">input </span><span style="color: #ff0000;">type</span><span style="color: #0000ff;">="text"</span><span style="color: #ff0000;"> id</span><span style="color: #0000ff;">="verifyCode"</span><span style="color: #ff0000;"> name</span><span style="color: #0000ff;">="verifyCode"</span><span style="color: #ff0000;"> size</span><span style="color: #0000ff;">="6"</span> <span style="color: #0000ff;">/&gt;</span>
<span style="color: #008080;">12</span>     <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">a </span><span style="color: #ff0000;">href</span><span style="color: #0000ff;">="javascript:reloadCode();"</span><span style="color: #0000ff;">&gt;</span>看不清楚<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">a</span><span style="color: #0000ff;">&gt;&lt;</span><span style="color: #800000;">br</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;">13</span>     <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">input </span><span style="color: #ff0000;">type</span><span style="color: #0000ff;">="submit"</span><span style="color: #ff0000;"> value</span><span style="color: #0000ff;">="登录"</span> <span style="color: #0000ff;">/&gt;</span>
<span style="color: #008080;">14</span> <span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">form</span><span style="color: #0000ff;">&gt;</span></pre>
</div>
<p><span style="line-height: 1.5;">　　我们用</span><strong style="line-height: 1.5;">ImageServle</strong><span style="line-height: 1.5;">t实时生成图片。生成图片所需要的步骤如下：</span></p>
<div class="cnblogs_code">
<pre><span style="color: #008080;">1</span> <span style="color: #000000;">定义BufferedImage对象
</span><span style="color: #008080;">2</span> <span style="color: #000000;">获得Graphics对象
</span><span style="color: #008080;">3</span> <span style="color: #000000;">听过Random类产生随机验证码信息
</span><span style="color: #008080;">4</span> <span style="color: #000000;">使用Graphics绘制图片
</span><span style="color: #008080;">5</span> <span style="color: #000000;">记录验证码信息到session中
</span><span style="color: #008080;">6</span> 使用ImageIO输出图片</pre>
</div>
<p>　　检验验证码是否正确：<strong>ValidateImageServlet</strong>：</p>
<div class="cnblogs_code">
<pre><span style="color: #008080;">1</span> <span style="color: #000000;">获取页面的验证码
</span><span style="color: #008080;">2</span> <span style="color: #000000;">获取session中保存的验证码
</span><span style="color: #008080;">3</span> <span style="color: #000000;">比较验证码
</span><span style="color: #008080;">4</span> 返回校验结果</pre>
</div>
<p>　　验证的流程如下：</p>
<p><img src="https://images0.cnblogs.com/blog2015/698228/201505/081902260797835.jpg" alt="" /></p>
<p>　　生成验证码的ImageServlet：</p>
<div class="cnblogs_code">
<pre><span style="color: #008080;"> 1</span> <span style="color: #0000ff;">private</span> <span style="color: #0000ff;">static</span> Random r = <span style="color: #0000ff;">new</span><span style="color: #000000;"> Random();
</span><span style="color: #008080;"> 2</span>     <span style="color: #0000ff;">private</span> <span style="color: #0000ff;">static</span> <span style="color: #0000ff;">char</span>[] chs = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"<span style="color: #000000;">.toCharArray();
</span><span style="color: #008080;"> 3</span>     <span style="color: #0000ff;">private</span> <span style="color: #0000ff;">static</span> <span style="color: #0000ff;">final</span> <span style="color: #0000ff;">int</span> NUMBER_OF_CHS = 4<span style="color: #000000;">;
</span><span style="color: #008080;"> 4</span>     <span style="color: #0000ff;">private</span> <span style="color: #0000ff;">static</span> <span style="color: #0000ff;">final</span> <span style="color: #0000ff;">int</span> IMG_WIDTH = 65<span style="color: #000000;">;
</span><span style="color: #008080;"> 5</span>     <span style="color: #0000ff;">private</span> <span style="color: #0000ff;">static</span> <span style="color: #0000ff;">final</span> <span style="color: #0000ff;">int</span> IMG_HEIGHT = 25<span style="color: #000000;">;
</span><span style="color: #008080;"> 6</span>     
<span style="color: #008080;"> 7</span>     
<span style="color: #008080;"> 8</span>     <span style="color: #0000ff;">public</span> <span style="color: #0000ff;">void</span><span style="color: #000000;"> doGet(HttpServletRequest request, HttpServletResponse response)
</span><span style="color: #008080;"> 9</span>             <span style="color: #0000ff;">throws</span><span style="color: #000000;"> ServletException, IOException {
</span><span style="color: #008080;">10</span> 
<span style="color: #008080;">11</span>             BufferedImage image = <span style="color: #0000ff;">new</span> BufferedImage(IMG_WIDTH, IMG_HEIGHT, BufferedImage.TYPE_INT_RGB);    <span style="color: #008000;">//</span><span style="color: #008000;"> 实例化BufferedImage</span>
<span style="color: #008080;">12</span>             Graphics g =<span style="color: #000000;"> image.getGraphics();
</span><span style="color: #008080;">13</span>             Color c = <span style="color: #0000ff;">new</span> Color(200, 200, 255);                                             <span style="color: #008000;">//</span><span style="color: #008000;"> 验证码图片的背景颜色                                        </span>
<span style="color: #008080;">14</span> <span style="color: #000000;">            g.setColor(c);
</span><span style="color: #008080;">15</span>             g.fillRect(0, 0, IMG_WIDTH, IMG_HEIGHT);                                        <span style="color: #008000;">//</span><span style="color: #008000;"> 图片的边框</span>
<span style="color: #008080;">16</span>             
<span style="color: #008080;">17</span>             StringBuffer sb = <span style="color: #0000ff;">new</span> StringBuffer();                                           <span style="color: #008000;">//</span><span style="color: #008000;"> 用于保存验证码字符串</span>
<span style="color: #008080;">18</span>             <span style="color: #0000ff;">int</span> index;                                                                      <span style="color: #008000;">//</span><span style="color: #008000;"> 数组的下标</span>
<span style="color: #008080;">19</span>             <span style="color: #0000ff;">for</span> (<span style="color: #0000ff;">int</span> i = 0; i &lt; NUMBER_OF_CHS; i++<span style="color: #000000;">) {
</span><span style="color: #008080;">20</span>                 index = r.nextInt(chs.length);                                              <span style="color: #008000;">//</span><span style="color: #008000;"> 随机一个下标</span>
<span style="color: #008080;">21</span>                 g.setColor(<span style="color: #0000ff;">new</span> Color(r.nextInt(88), r.nextInt(210), r.nextInt(150)));       <span style="color: #008000;">//</span><span style="color: #008000;"> 随机一个颜色</span>
<span style="color: #008080;">22</span>                 g.drawString(chs[index] + "", 15 * i + 3, 18);                              <span style="color: #008000;">//</span><span style="color: #008000;"> 画出字符</span>
<span style="color: #008080;">23</span>                 sb.append(chs[index]);                                                      <span style="color: #008000;">//</span><span style="color: #008000;"> 验证码字符串</span>
<span style="color: #008080;">24</span> <span style="color: #000000;">            }
</span><span style="color: #008080;">25</span>             
<span style="color: #008080;">26</span>             request.getSession().setAttribute("piccode", sb.toString());                    <span style="color: #008000;">//</span><span style="color: #008000;"> 将验证码字符串保存到session中</span>
<span style="color: #008080;">27</span>             ImageIO.write(image, "jpg", response.getOutputStream());                        <span style="color: #008000;">//</span><span style="color: #008000;"> 向页面输出图像</span>
<span style="color: #008080;">28</span> <span style="color: #000000;">    }
</span><span style="color: #008080;">29</span> 
<span style="color: #008080;">30</span>     <span style="color: #0000ff;">public</span> <span style="color: #0000ff;">void</span><span style="color: #000000;"> doPost(HttpServletRequest request, HttpServletResponse response)
</span><span style="color: #008080;">31</span>             <span style="color: #0000ff;">throws</span><span style="color: #000000;"> ServletException, IOException {
</span><span style="color: #008080;">32</span> <span style="color: #000000;">        doGet(request, response);
</span><span style="color: #008080;">33</span> <span style="color: #000000;">    }
</span><span style="color: #008080;">34</span> 
<span style="color: #008080;">35</span> }</pre>
</div>
<p>　　进行验证码图片验证的Servlet：</p>
<div class="cnblogs_code">
<pre><span style="color: #008080;"> 1</span> <span style="color: #0000ff;">public</span> <span style="color: #0000ff;">class</span> ValidateImageServlet <span style="color: #0000ff;">extends</span><span style="color: #000000;"> HttpServlet {
</span><span style="color: #008080;"> 2</span> 
<span style="color: #008080;"> 3</span>     <span style="color: #0000ff;">public</span> <span style="color: #0000ff;">void</span><span style="color: #000000;"> doGet(HttpServletRequest request, HttpServletResponse response)
</span><span style="color: #008080;"> 4</span>             <span style="color: #0000ff;">throws</span><span style="color: #000000;"> ServletException, IOException {
</span><span style="color: #008080;"> 5</span>         
<span style="color: #008080;"> 6</span> <span style="color: #000000;">        doPost(request, response);
</span><span style="color: #008080;"> 7</span> <span style="color: #000000;">    }
</span><span style="color: #008080;"> 8</span> 
<span style="color: #008080;"> 9</span>     <span style="color: #0000ff;">public</span> <span style="color: #0000ff;">void</span><span style="color: #000000;"> doPost(HttpServletRequest request, HttpServletResponse response)
</span><span style="color: #008080;">10</span>             <span style="color: #0000ff;">throws</span><span style="color: #000000;"> ServletException, IOException {
</span><span style="color: #008080;">11</span> 
<span style="color: #008080;">12</span>         response.setContentType("text/html;charset=utf-8"<span style="color: #000000;">);
</span><span style="color: #008080;">13</span>         String picString = (String) request.getSession().getAttribute("piccode"<span style="color: #000000;">);
</span><span style="color: #008080;">14</span>         String checkCode = request.getParameter("verifyCode"<span style="color: #000000;">);
</span><span style="color: #008080;">15</span>         PrintWriter out =<span style="color: #000000;"> response.getWriter();
</span><span style="color: #008080;">16</span>         <span style="color: #0000ff;">if</span><span style="color: #000000;"> (picString.toUpperCase().equals(checkCode.toUpperCase()))
</span><span style="color: #008080;">17</span>             out.println("验证码正确"<span style="color: #000000;">);
</span><span style="color: #008080;">18</span>         <span style="color: #0000ff;">else</span>
<span style="color: #008080;">19</span>             out.print("验证码错误！"<span style="color: #000000;">);
</span><span style="color: #008080;">20</span>         
<span style="color: #008080;">21</span> <span style="color: #000000;">        out.flush();
</span><span style="color: #008080;">22</span> <span style="color: #000000;">        out.close();
</span><span style="color: #008080;">23</span> <span style="color: #000000;">    }
</span><span style="color: #008080;">24</span> 
<span style="color: #008080;">25</span> }</pre>
</div>
<h1>&nbsp;开源组件实现验证码</h1>
<p><img src="https://images0.cnblogs.com/blog2015/698228/201505/082211353456538.jpg" alt="" /></p>
<h2>　　Jcaptcha：</h2>
<p>　　一个用来生成图形验证码的开源组件，可以产生多种形式的验证码。可以与Spring组合使用。需要导入的jar包如下：</p>
<p><img src="https://images0.cnblogs.com/blog2015/698228/201505/202219064942839.jpg" alt="" /></p>
<p>　　用于展示验证码的auth_code_captcha.jsp如下：</p>
<div class="cnblogs_code">
<pre><span style="color: #008080;">1</span> <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">form </span><span style="color: #ff0000;">action</span><span style="color: #0000ff;">="submit.action"</span><span style="color: #ff0000;"> method</span><span style="color: #0000ff;">="post"</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;">2</span>      <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">img </span><span style="color: #ff0000;">src</span><span style="color: #0000ff;">="jcaptcha.jpg"</span> <span style="color: #0000ff;">/&gt;</span> <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">input </span><span style="color: #ff0000;">type</span><span style="color: #0000ff;">="text"</span><span style="color: #ff0000;"> name</span><span style="color: #0000ff;">="japtcha"</span><span style="color: #ff0000;"> value</span><span style="color: #0000ff;">=""</span> <span style="color: #0000ff;">/&gt;</span>
<span style="color: #008080;">3</span>      <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">input </span><span style="color: #ff0000;">type</span><span style="color: #0000ff;">="submit"</span><span style="color: #0000ff;">/&gt;</span>
<span style="color: #008080;">4</span> <span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">form</span><span style="color: #0000ff;">&gt;</span></pre>
</div>
<p>　　web.xml的配置如下：</p>
<div class="cnblogs_code">
<pre><span style="color: #008080;"> 1</span> <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">servlet</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 2</span>     <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">servlet-name</span><span style="color: #0000ff;">&gt;</span>jcaptcha<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">servlet-name</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 3</span>     <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">servlet-class</span><span style="color: #0000ff;">&gt;</span>com.octo.captcha.module.servlet.image.SimpleImageCaptchaServlet<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">servlet-class</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 4</span> <span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">servlet</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 5</span> <span style="color: #008000;">&lt;!--</span><span style="color: #008000;"> 处理表单提交的Servlet </span><span style="color: #008000;">--&gt;</span>
<span style="color: #008080;"> 6</span> <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">servlet</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 7</span>     <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">servlet-name</span><span style="color: #0000ff;">&gt;</span>submit<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">servlet-name</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 8</span>     <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">servlet-class</span><span style="color: #0000ff;">&gt;</span>org.gpf.servlet.SubmitActionServlet<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">servlet-class</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 9</span> <span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">servlet</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;">10</span> <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">servlet-mapping</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;">11</span>     <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">servlet-name</span><span style="color: #0000ff;">&gt;</span>jcaptcha<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">servlet-name</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;">12</span>     <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">url-pattern</span><span style="color: #0000ff;">&gt;</span>/jcaptcha.jpg<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">url-pattern</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;">13</span> <span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">servlet-mapping</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;">14</span> <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">servlet-mapping</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;">15</span>     <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">servlet-name</span><span style="color: #0000ff;">&gt;</span>submit<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">servlet-name</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;">16</span>     <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">url-pattern</span><span style="color: #0000ff;">&gt;</span>/submit.action<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">url-pattern</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;">17</span> <span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">servlet-mapping</span><span style="color: #0000ff;">&gt;</span></pre>
</div>
<p>　　表单提交的Servlet：</p>
<div class="cnblogs_code">
<pre><span style="color: #008080;"> 1</span> <span style="color: #0000ff;">package</span><span style="color: #000000;"> org.gpf.servlet;
</span><span style="color: #008080;"> 2</span> 
<span style="color: #008080;"> 3</span> <span style="color: #0000ff;">import</span><span style="color: #000000;"> java.io.IOException;
</span><span style="color: #008080;"> 4</span> 
<span style="color: #008080;"> 5</span> <span style="color: #0000ff;">import</span><span style="color: #000000;"> javax.servlet.ServletException;
</span><span style="color: #008080;"> 6</span> <span style="color: #0000ff;">import</span><span style="color: #000000;"> javax.servlet.http.HttpServlet;
</span><span style="color: #008080;"> 7</span> <span style="color: #0000ff;">import</span><span style="color: #000000;"> javax.servlet.http.HttpServletRequest;
</span><span style="color: #008080;"> 8</span> <span style="color: #0000ff;">import</span><span style="color: #000000;"> javax.servlet.http.HttpServletResponse;
</span><span style="color: #008080;"> 9</span> 
<span style="color: #008080;">10</span> <span style="color: #0000ff;">import</span><span style="color: #000000;"> com.octo.captcha.module.servlet.image.SimpleImageCaptchaServlet;
</span><span style="color: #008080;">11</span> <span style="color: #008000;">/**</span>
<span style="color: #008080;">12</span> <span style="color: #008000;"> * 图片验证码的captcha实现
</span><span style="color: #008080;">13</span> <span style="color: #008000;"> * </span><span style="color: #808080;">@author</span><span style="color: #008000;"> gaopengfei
</span><span style="color: #008080;">14</span> <span style="color: #008000;"> * @date 2015-5-20 下午9:58:20
</span><span style="color: #008080;">15</span>  <span style="color: #008000;">*/</span>
<span style="color: #008080;">16</span> <span style="color: #0000ff;">public</span> <span style="color: #0000ff;">class</span> SubmitActionServlet <span style="color: #0000ff;">extends</span><span style="color: #000000;"> HttpServlet {
</span><span style="color: #008080;">17</span>     
<span style="color: #008080;">18</span>     <span style="color: #0000ff;">private</span> <span style="color: #0000ff;">static</span> <span style="color: #0000ff;">final</span> <span style="color: #0000ff;">long</span> serialVersionUID = 1L<span style="color: #000000;">;
</span><span style="color: #008080;">19</span> 
<span style="color: #008080;">20</span>     <span style="color: #0000ff;">protected</span> <span style="color: #0000ff;">void</span><span style="color: #000000;"> doPost(HttpServletRequest request,
</span><span style="color: #008080;">21</span>             HttpServletResponse response) <span style="color: #0000ff;">throws</span><span style="color: #000000;"> ServletException, IOException {
</span><span style="color: #008080;">22</span>         
<span style="color: #008080;">23</span>         String userCaptchaResponse = request.getParameter("japtcha"<span style="color: #000000;">);
</span><span style="color: #008080;">24</span>         <span style="color: #0000ff;">boolean</span> captchaPassed =<span style="color: #000000;"> SimpleImageCaptchaServlet.validateResponse(request, userCaptchaResponse);
</span><span style="color: #008080;">25</span>         
<span style="color: #008080;">26</span>         response.setContentType("text/html;charset=utf-8"<span style="color: #000000;">);
</span><span style="color: #008080;">27</span>         <span style="color: #0000ff;">if</span><span style="color: #000000;"> (captchaPassed)
</span><span style="color: #008080;">28</span>             response.getWriter().write("验证通过！"<span style="color: #000000;">);
</span><span style="color: #008080;">29</span>         <span style="color: #0000ff;">else</span><span style="color: #000000;"> {
</span><span style="color: #008080;">30</span>             response.getWriter().write("验证失败！"<span style="color: #000000;">);
</span><span style="color: #008080;">31</span> <span style="color: #000000;">        }
</span><span style="color: #008080;">32</span>         response.getWriter().write("&lt;br/&gt;&lt;a href='auth_code_captcha.jsp'&gt;重新验证&lt;/a&gt;"<span style="color: #000000;">);
</span><span style="color: #008080;">33</span> <span style="color: #000000;">    }
</span><span style="color: #008080;">34</span> }</pre>
</div>
<p>　　<img src="https://images0.cnblogs.com/blog2015/698228/201505/202230533546820.jpg" alt="" /></p>
<h2>　　kaptcha：</h2>
<p>　　它是可以配置的，也可以生成各种样式的验证码。如下是其简单应用：用于显示验证码的index.jsp</p>
<div class="cnblogs_code">
<pre><span style="color: #008080;">1</span> <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">img </span><span style="color: #ff0000;">alt</span><span style="color: #0000ff;">="验证码图片"</span><span style="color: #ff0000;"> src</span><span style="color: #0000ff;">="random.jpg"</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;">2</span> <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">form </span><span style="color: #ff0000;">action</span><span style="color: #0000ff;">="check.jsp"</span><span style="color: #ff0000;"> method</span><span style="color: #0000ff;">="post"</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;">3</span>     <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">input </span><span style="color: #ff0000;">type</span><span style="color: #0000ff;">="text"</span><span style="color: #ff0000;"> name</span><span style="color: #0000ff;">="imageText"</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;">4</span>     <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">input </span><span style="color: #ff0000;">type</span><span style="color: #0000ff;">="submit"</span><span style="color: #ff0000;"> value</span><span style="color: #0000ff;">="验证"</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;">5</span> <span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">form</span><span style="color: #0000ff;">&gt;</span></pre>
</div>
<p>　　用于验证验证码的check.jsp</p>
<div class="cnblogs_code">
<pre><span style="color: #008080;"> 1</span> <span style="background-color: #ffff00; color: #000000;">&lt;%</span><span style="background-color: #f5f5f5; color: #000000;">@ page import</span><span style="background-color: #f5f5f5; color: #000000;">=</span><span style="background-color: #f5f5f5; color: #800000;">"</span><span style="background-color: #f5f5f5; color: #800000;">com.google.code.kaptcha.Constants</span><span style="background-color: #f5f5f5; color: #800000;">"</span> <span style="background-color: #ffff00; color: #000000;">%&gt;</span>
<span style="color: #008080;"> 2</span> <span style="background-color: #ffff00; color: #000000;">&lt;%</span><span style="background-color: #f5f5f5; color: #000000;">@ page language</span><span style="background-color: #f5f5f5; color: #000000;">=</span><span style="background-color: #f5f5f5; color: #800000;">"</span><span style="background-color: #f5f5f5; color: #800000;">java</span><span style="background-color: #f5f5f5; color: #800000;">"</span><span style="background-color: #f5f5f5; color: #000000;"> import</span><span style="background-color: #f5f5f5; color: #000000;">=</span><span style="background-color: #f5f5f5; color: #800000;">"</span><span style="background-color: #f5f5f5; color: #800000;">java.util.*</span><span style="background-color: #f5f5f5; color: #800000;">"</span><span style="background-color: #f5f5f5; color: #000000;"> contentType</span><span style="background-color: #f5f5f5; color: #000000;">=</span><span style="background-color: #f5f5f5; color: #800000;">"</span><span style="background-color: #f5f5f5; color: #800000;">text/html; charset=utf-8</span><span style="background-color: #f5f5f5; color: #800000;">"</span><span style="background-color: #ffff00; color: #000000;">%&gt;</span>
<span style="color: #008080;"> 3</span> <span style="background-color: #ffff00; color: #000000;">&lt;%</span>
<span style="color: #008080;"> 4</span>     <span style="background-color: #f5f5f5; color: #0000ff;">String</span><span style="background-color: #f5f5f5; color: #000000;"> myImageText </span><span style="background-color: #f5f5f5; color: #000000;">=</span><span style="background-color: #f5f5f5; color: #000000;"> request.getParameter(</span><span style="background-color: #f5f5f5; color: #800000;">"</span><span style="background-color: #f5f5f5; color: #800000;">imageText</span><span style="background-color: #f5f5f5; color: #800000;">"</span><span style="background-color: #f5f5f5; color: #000000;">);
</span><span style="color: #008080;"> 5</span>     <span style="background-color: #f5f5f5; color: #0000ff;">String</span><span style="background-color: #f5f5f5; color: #000000;"> key </span><span style="background-color: #f5f5f5; color: #000000;">=</span><span style="background-color: #f5f5f5; color: #000000;"> (</span><span style="background-color: #f5f5f5; color: #0000ff;">String</span><span style="background-color: #f5f5f5; color: #000000;">)request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
</span><span style="color: #008080;"> 6</span>     
<span style="color: #008080;"> 7</span>     <span style="background-color: #f5f5f5; color: #0000ff;">if</span><span style="background-color: #f5f5f5; color: #000000;">(!myImageText.isEmpty() </span><span style="background-color: #f5f5f5; color: #000000;">&amp;&amp;</span><span style="background-color: #f5f5f5; color: #000000;"> myImageText.equals(key))
</span><span style="color: #008080;"> 8</span> <span style="background-color: #f5f5f5; color: #000000;">        out.print(</span><span style="background-color: #f5f5f5; color: #800000;">"</span><span style="background-color: #f5f5f5; color: #800000;">验证通过！&lt;br /&gt;</span><span style="background-color: #f5f5f5; color: #800000;">"</span><span style="background-color: #f5f5f5; color: #000000;">);
</span><span style="color: #008080;"> 9</span>     <span style="background-color: #f5f5f5; color: #0000ff;">else</span>
<span style="color: #008080;">10</span> <span style="background-color: #f5f5f5; color: #000000;">        out.print(</span><span style="background-color: #f5f5f5; color: #800000;">"</span><span style="background-color: #f5f5f5; color: #800000;">验证失败！&lt;br /&gt;</span><span style="background-color: #f5f5f5; color: #800000;">"</span><span style="background-color: #f5f5f5; color: #000000;">);    
</span><span style="color: #008080;">11</span> <span style="background-color: #f5f5f5; color: #000000;">    out.print(</span><span style="background-color: #f5f5f5; color: #800000;">"</span><span style="background-color: #f5f5f5; color: #800000;">你输入的字符：</span><span style="background-color: #f5f5f5; color: #800000;">"</span> <span style="background-color: #f5f5f5; color: #000000;">+</span><span style="background-color: #f5f5f5; color: #000000;"> myImageText </span><span style="background-color: #f5f5f5; color: #000000;">+</span> <span style="background-color: #f5f5f5; color: #800000;">"</span><span style="background-color: #f5f5f5; color: #800000;">,验证码字符：</span><span style="background-color: #f5f5f5; color: #800000;">"</span> <span style="background-color: #f5f5f5; color: #000000;">+</span><span style="background-color: #f5f5f5; color: #000000;"> key);    
</span><span style="color: #008080;">12</span>  <span style="background-color: #ffff00; color: #000000;">%&gt;</span></pre>
</div>
<p>　　配置图片显示的Servlet：</p>
<div class="cnblogs_code">
<pre><span style="color: #008080;">1</span> <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">servlet</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;">2</span>     <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">servlet-name</span><span style="color: #0000ff;">&gt;</span>Kcaptcha<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">servlet-name</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;">3</span>     <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">servlet-class</span><span style="color: #0000ff;">&gt;</span>com.google.code.kaptcha.servlet.KaptchaServlet<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">servlet-class</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;">4</span> <span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">servlet</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;">5</span> <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">servlet-mapping</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;">6</span>     <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">servlet-name</span><span style="color: #0000ff;">&gt;</span>Kcaptcha<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">servlet-name</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;">7</span>     <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">url-pattern</span><span style="color: #0000ff;">&gt;</span>/random.jpg<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">url-pattern</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;">8</span> <span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">servlet-mapping</span><span style="color: #0000ff;">&gt;</span></pre>
</div>
<p>　　<img src="https://images0.cnblogs.com/blog2015/698228/201505/211124161826846.jpg" alt="" /></p>
<h2>Kaptcha的详细配置</h2>
<div class="cnblogs_code">
<pre><span style="color: #008080;">  1</span> <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">servlet</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;">  2</span>     <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">servlet-name</span><span style="color: #0000ff;">&gt;</span>Kcaptcha<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">servlet-name</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;">  3</span>     <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">servlet-class</span><span style="color: #0000ff;">&gt;</span>com.google.code.kaptcha.servlet.KaptchaServlet<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">servlet-class</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;">  4</span>     
<span style="color: #008080;">  5</span>     <span style="color: #008000;">&lt;!--</span><span style="color: #008000;"> 边框 </span><span style="color: #008000;">--&gt;</span>
<span style="color: #008080;">  6</span>     <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">init-param</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;">  7</span>         <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">description</span><span style="color: #0000ff;">&gt;</span>图片边框，yes（默认值）或者no<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">description</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;">  8</span>         <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">param-name</span><span style="color: #0000ff;">&gt;</span>kaptcha.border<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">param-name</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;">  9</span>         <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">param-value</span><span style="color: #0000ff;">&gt;</span>yes<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">param-value</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 10</span>     <span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">init-param</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 11</span>     <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">init-param</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 12</span>         <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">description</span><span style="color: #0000ff;">&gt;</span>边框颜色，white、black（默认）、blue等<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">description</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 13</span>         <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">param-name</span><span style="color: #0000ff;">&gt;</span>kaptcha.border.color<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">param-name</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 14</span>         <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">param-value</span><span style="color: #0000ff;">&gt;</span>green<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">param-value</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 15</span>     <span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">init-param</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 16</span>     <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">init-param</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 17</span>         <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">description</span><span style="color: #0000ff;">&gt;</span>边框厚度大于0<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">description</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 18</span>         <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">param-name</span><span style="color: #0000ff;">&gt;</span>kaptcha.border.thickness<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">param-name</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 19</span>         <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">param-value</span><span style="color: #0000ff;">&gt;</span>10<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">param-value</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 20</span>     <span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">init-param</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 21</span>     
<span style="color: #008080;"> 22</span>     <span style="color: #008000;">&lt;!--</span><span style="color: #008000;"> 图片宽高 </span><span style="color: #008000;">--&gt;</span>
<span style="color: #008080;"> 23</span>     <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">init-param</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 24</span>         <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">description</span><span style="color: #0000ff;">&gt;</span>图片宽度<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">description</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 25</span>         <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">param-name</span><span style="color: #0000ff;">&gt;</span>kaptcha.image.width<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">param-name</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 26</span>         <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">param-value</span><span style="color: #0000ff;">&gt;</span>200<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">param-value</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 27</span>     <span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">init-param</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 28</span>     <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">init-param</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 29</span>         <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">description</span><span style="color: #0000ff;">&gt;</span>图片高度<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">description</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 30</span>         <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">param-name</span><span style="color: #0000ff;">&gt;</span>kaptcha.image.height<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">param-name</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 31</span>         <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">param-value</span><span style="color: #0000ff;">&gt;</span>60<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">param-value</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 32</span>     <span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">init-param</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 33</span> 
<span style="color: #008080;"> 34</span>     <span style="color: #008000;">&lt;!--</span><span style="color: #008000;"> 图片样式 </span><span style="color: #008000;">--&gt;</span>
<span style="color: #008080;"> 35</span>     <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">init-param</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 36</span>         <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">description</span><span style="color: #0000ff;">&gt;</span>图片样式：水纹(WaterRipple)、鱼眼(FishEyeGimpy)、阴影(ShadowGimpy)<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">description</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 37</span>         <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">param-name</span><span style="color: #0000ff;">&gt;</span>kaptcha.obscurificator.impl<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">param-name</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 38</span>         <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">param-value</span><span style="color: #0000ff;">&gt;</span>com.google.code.kaptcha.impl.ShadowGimpy<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">param-value</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 39</span>     <span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">init-param</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 40</span>     
<span style="color: #008080;"> 41</span>     <span style="color: #008000;">&lt;!--</span><span style="color: #008000;"> 背景 </span><span style="color: #008000;">--&gt;</span>
<span style="color: #008080;"> 42</span>     <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">init-param</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 43</span>         <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">description</span><span style="color: #0000ff;">&gt;</span>背景实现类<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">description</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 44</span>         <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">param-name</span><span style="color: #0000ff;">&gt;</span>kaptcha.background.impl<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">param-name</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 45</span>         <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">param-value</span><span style="color: #0000ff;">&gt;</span>com.google.code.kaptcha.impl.DefaultBackground<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">param-value</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 46</span>     <span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">init-param</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 47</span>     <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">init-param</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 48</span>         <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">description</span><span style="color: #0000ff;">&gt;</span>背景颜色渐变，指定开始颜色<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">description</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 49</span>         <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">param-name</span><span style="color: #0000ff;">&gt;</span>kaptcha.background.clear.from<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">param-name</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 50</span>         <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">param-value</span><span style="color: #0000ff;">&gt;</span>yellow<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">param-value</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 51</span>     <span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">init-param</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 52</span>     <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">init-param</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 53</span>         <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">description</span><span style="color: #0000ff;">&gt;</span>背景颜色渐变，指定结束颜色<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">description</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 54</span>         <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">param-name</span><span style="color: #0000ff;">&gt;</span>kaptcha.background.clear.to<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">param-name</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 55</span>         <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">param-value</span><span style="color: #0000ff;">&gt;</span>red<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">param-value</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 56</span>     <span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">init-param</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 57</span>     
<span style="color: #008080;"> 58</span>     <span style="color: #008000;">&lt;!--</span><span style="color: #008000;"> 文本 </span><span style="color: #008000;">--&gt;</span>
<span style="color: #008080;"> 59</span>     <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">init-param</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 60</span>         <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">description</span><span style="color: #0000ff;">&gt;</span>文本集合，验证码文字从此集合中获取<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">description</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 61</span>         <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">param-name</span><span style="color: #0000ff;">&gt;</span>kaptcha.textproducer.char.string<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">param-name</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 62</span>         <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">param-value</span><span style="color: #0000ff;">&gt;</span>0123456789<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">param-value</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 63</span>     <span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">init-param</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 64</span>     <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">init-param</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 65</span>         <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">description</span><span style="color: #0000ff;">&gt;</span>验证码长度<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">description</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 66</span>         <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">param-name</span><span style="color: #0000ff;">&gt;</span>kaptcha.textproducer.char.length<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">param-name</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 67</span>         <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">param-value</span><span style="color: #0000ff;">&gt;</span>6<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">param-value</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 68</span>     <span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">init-param</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 69</span>     <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">init-param</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 70</span>         <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">description</span><span style="color: #0000ff;">&gt;</span>文字间隔<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">description</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 71</span>         <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">param-name</span><span style="color: #0000ff;">&gt;</span>kaptcha.textproducer.char.space<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">param-name</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 72</span>         <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">param-value</span><span style="color: #0000ff;">&gt;</span>2<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">param-value</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 73</span>     <span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">init-param</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 74</span>     <span style="color: #008000;">&lt;!--</span><span style="color: #008000;"> 字体 </span><span style="color: #008000;">--&gt;</span>
<span style="color: #008080;"> 75</span>     <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">init-param</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 76</span>         <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">description</span><span style="color: #0000ff;">&gt;</span>字体Arial，Courier<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">description</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 77</span>         <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">param-name</span><span style="color: #0000ff;">&gt;</span>kaptcha.textproducer.font.names<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">param-name</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 78</span>         <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">param-value</span><span style="color: #0000ff;">&gt;</span>Arial,Courier<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">param-value</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 79</span>     <span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">init-param</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 80</span>     <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">init-param</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 81</span>         <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">description</span><span style="color: #0000ff;">&gt;</span>字体大小<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">description</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 82</span>         <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">param-name</span><span style="color: #0000ff;">&gt;</span>kaptcha.textproducer.font.size<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">param-name</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 83</span>         <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">param-value</span><span style="color: #0000ff;">&gt;</span>40<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">param-value</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 84</span>     <span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">init-param</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 85</span>     <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">init-param</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 86</span>         <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">description</span><span style="color: #0000ff;">&gt;</span>字体颜色，white、black（默认）、blue等<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">description</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 87</span>         <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">param-name</span><span style="color: #0000ff;">&gt;</span>kaptcha.textproducer.font.color<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">param-name</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 88</span>         <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">param-value</span><span style="color: #0000ff;">&gt;</span>pink<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">param-value</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 89</span>     <span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">init-param</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 90</span> 
<span style="color: #008080;"> 91</span>     <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">init-param</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 92</span>         <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">description</span><span style="color: #0000ff;">&gt;</span>文字渲染器<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">description</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 93</span>         <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">param-name</span><span style="color: #0000ff;">&gt;</span>kaptcha.word.impl<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">param-name</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 94</span>         <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">param-value</span><span style="color: #0000ff;">&gt;</span>com.google.code.kaptcha.text.impl.DefaultWordRenderer<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">param-value</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 95</span>     <span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">init-param</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 96</span> 
<span style="color: #008080;"> 97</span>     <span style="color: #008000;">&lt;!--</span><span style="color: #008000;"> 图片和文本的实现类 </span><span style="color: #008000;">--&gt;</span>
<span style="color: #008080;"> 98</span>     <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">init-param</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 99</span>         <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">description</span><span style="color: #0000ff;">&gt;</span>图片实现类,可以重写这个类实现我们自己的图片<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">description</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;">100</span>         <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">param-name</span><span style="color: #0000ff;">&gt;</span>kaptcha.producer.impl<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">param-name</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;">101</span>         <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">param-value</span><span style="color: #0000ff;">&gt;</span>com.google.code.kaptcha.impl.DefaultKaptcha<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">param-value</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;">102</span>     <span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">init-param</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;">103</span>     <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">init-param</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;">104</span>         <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">description</span><span style="color: #0000ff;">&gt;</span>文本实现类<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">description</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;">105</span>         <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">param-name</span><span style="color: #0000ff;">&gt;</span>kaptcha.textproducer.impl<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">param-name</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;">106</span>         <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">param-value</span><span style="color: #0000ff;">&gt;</span>com.google.code.kaptcha.text.impl.DefaultTextCreator<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">param-value</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;">107</span>     <span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">init-param</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;">108</span>     
<span style="color: #008080;">109</span>     <span style="color: #008000;">&lt;!--</span><span style="color: #008000;"> 干扰 </span><span style="color: #008000;">--&gt;</span>
<span style="color: #008080;">110</span>     <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">init-param</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;">111</span>         <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">description</span><span style="color: #0000ff;">&gt;</span>干扰实现类<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">description</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;">112</span>         <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">param-name</span><span style="color: #0000ff;">&gt;</span>kaptcha.noise.impl<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">param-name</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;">113</span>         <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">param-value</span><span style="color: #0000ff;">&gt;</span>com.google.code.kaptcha.impl.DefaultNoise<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">param-value</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;">114</span>     <span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">init-param</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;">115</span>     <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">init-param</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;">116</span>         <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">description</span><span style="color: #0000ff;">&gt;</span>干扰颜色,合法值r,g,b或者white、black、blue<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">description</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;">117</span>         <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">param-name</span><span style="color: #0000ff;">&gt;</span>kaptcha.noise.color<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">param-name</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;">118</span>         <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">param-value</span><span style="color: #0000ff;">&gt;</span>255,0,0<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">param-value</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;">119</span>     <span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">init-param</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;">120</span>     
<span style="color: #008080;">121</span>     <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">init-param</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;">122</span>         <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">description</span><span style="color: #0000ff;">&gt;</span>session中存放验证码的key键<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">description</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;">123</span>         <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">param-name</span><span style="color: #0000ff;">&gt;</span>kaptcha.session.key<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">param-name</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;">124</span>         <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">param-value</span><span style="color: #0000ff;">&gt;</span>KAPTCHA_SESSION_KEY<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">param-value</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;">125</span>     <span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">init-param</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;">126</span> <span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">servlet</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;">127</span> <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">servlet-mapping</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;">128</span>     <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">servlet-name</span><span style="color: #0000ff;">&gt;</span>Kcaptcha<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">servlet-name</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;">129</span>     <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">url-pattern</span><span style="color: #0000ff;">&gt;</span>/random.jpg<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">url-pattern</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;">130</span> <span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">servlet-mapping</span><span style="color: #0000ff;">&gt;</span></pre>
</div>
<p><img src="https://images0.cnblogs.com/blog2015/698228/201505/211220024329477.jpg" alt="" /></p>
<h2>　　中文验证码</h2>
<p>　　查看前面的配置发现验证码字符的生成主要依靠的是kaptcha.textproducer.impl这个文本实现类，查看com.google.code.kaptcha.text.impl.DefaultTextCreator的源码，发现了它继承自&nbsp;Configurable并实现了TextProducer接口。我们可以仿照它自定义我们自己的验证码中的文本生成器：</p>
<div class="cnblogs_code">
<pre><span style="color: #008080;"> 1</span> <span style="color: #008000;">/**</span>
<span style="color: #008080;"> 2</span> <span style="color: #008000;"> * 中文验证码的实现类
</span><span style="color: #008080;"> 3</span>  <span style="color: #008000;">*/</span>
<span style="color: #008080;"> 4</span> <span style="color: #0000ff;">public</span> <span style="color: #0000ff;">class</span> ChineseTextCreator <span style="color: #0000ff;">extends</span> Configurable <span style="color: #0000ff;">implements</span><span style="color: #000000;"> TextProducer {
</span><span style="color: #008080;"> 5</span> 
<span style="color: #008080;"> 6</span> <span style="color: #000000;">    @Override
</span><span style="color: #008080;"> 7</span>     <span style="color: #0000ff;">public</span><span style="color: #000000;"> String getText() {
</span><span style="color: #008080;"> 8</span> 
<span style="color: #008080;"> 9</span>         <span style="color: #0000ff;">int</span> length =<span style="color: #000000;"> getConfig().getTextProducerCharLength();
</span><span style="color: #008080;">10</span>         String finalWord = "", firstWord = ""<span style="color: #000000;">;
</span><span style="color: #008080;">11</span>         <span style="color: #0000ff;">int</span> tempInt = 0<span style="color: #000000;">;
</span><span style="color: #008080;">12</span>         String[] array = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"<span style="color: #000000;">,
</span><span style="color: #008080;">13</span>                 "a", "b", "c", "d", "e", "f"<span style="color: #000000;"> };
</span><span style="color: #008080;">14</span> 
<span style="color: #008080;">15</span>         Random rand = <span style="color: #0000ff;">new</span><span style="color: #000000;"> Random();
</span><span style="color: #008080;">16</span> 
<span style="color: #008080;">17</span>         <span style="color: #0000ff;">for</span> (<span style="color: #0000ff;">int</span> i = 0; i &lt; length; i++<span style="color: #000000;">) {
</span><span style="color: #008080;">18</span>             <span style="color: #0000ff;">switch</span><span style="color: #000000;"> (rand.nextInt(array.length)) {
</span><span style="color: #008080;">19</span>             <span style="color: #0000ff;">case</span> 1<span style="color: #000000;">:
</span><span style="color: #008080;">20</span>                 tempInt = rand.nextInt(26) + 65<span style="color: #000000;">;
</span><span style="color: #008080;">21</span>                 firstWord = String.valueOf((<span style="color: #0000ff;">char</span><span style="color: #000000;">) tempInt);
</span><span style="color: #008080;">22</span>                 <span style="color: #0000ff;">break</span><span style="color: #000000;">;
</span><span style="color: #008080;">23</span>             <span style="color: #0000ff;">case</span> 2<span style="color: #000000;">:
</span><span style="color: #008080;">24</span>                 <span style="color: #0000ff;">int</span><span style="color: #000000;"> r1,
</span><span style="color: #008080;">25</span> <span style="color: #000000;">                r2,
</span><span style="color: #008080;">26</span> <span style="color: #000000;">                r3,
</span><span style="color: #008080;">27</span> <span style="color: #000000;">                r4;
</span><span style="color: #008080;">28</span> <span style="color: #000000;">                String strH,
</span><span style="color: #008080;">29</span>                 strL;<span style="color: #008000;">//</span><span style="color: #008000;"> high&amp;low</span>
<span style="color: #008080;">30</span>                 r1 = rand.nextInt(3) + 11; <span style="color: #008000;">//</span><span style="color: #008000;"> 前闭后开[11,14)</span>
<span style="color: #008080;">31</span>                 <span style="color: #0000ff;">if</span> (r1 == 13<span style="color: #000000;">) {
</span><span style="color: #008080;">32</span>                     r2 = rand.nextInt(7<span style="color: #000000;">);
</span><span style="color: #008080;">33</span>                 } <span style="color: #0000ff;">else</span><span style="color: #000000;"> {
</span><span style="color: #008080;">34</span>                     r2 = rand.nextInt(16<span style="color: #000000;">);
</span><span style="color: #008080;">35</span> <span style="color: #000000;">                }
</span><span style="color: #008080;">36</span> 
<span style="color: #008080;">37</span>                 r3 = rand.nextInt(6) + 10<span style="color: #000000;">;
</span><span style="color: #008080;">38</span>                 <span style="color: #0000ff;">if</span> (r3 == 10<span style="color: #000000;">) {
</span><span style="color: #008080;">39</span>                     r4 = rand.nextInt(15) + 1<span style="color: #000000;">;
</span><span style="color: #008080;">40</span>                 } <span style="color: #0000ff;">else</span> <span style="color: #0000ff;">if</span> (r3 == 15<span style="color: #000000;">) {
</span><span style="color: #008080;">41</span>                     r4 = rand.nextInt(15<span style="color: #000000;">);
</span><span style="color: #008080;">42</span>                 } <span style="color: #0000ff;">else</span><span style="color: #000000;"> {
</span><span style="color: #008080;">43</span>                     r4 = rand.nextInt(16<span style="color: #000000;">);
</span><span style="color: #008080;">44</span> <span style="color: #000000;">                }
</span><span style="color: #008080;">45</span> 
<span style="color: #008080;">46</span>                 strH = array[r1] +<span style="color: #000000;"> array[r2];
</span><span style="color: #008080;">47</span>                 strL = array[r3] +<span style="color: #000000;"> array[r4];
</span><span style="color: #008080;">48</span> 
<span style="color: #008080;">49</span>                 <span style="color: #0000ff;">byte</span>[] bytes = <span style="color: #0000ff;">new</span> <span style="color: #0000ff;">byte</span>[2<span style="color: #000000;">];
</span><span style="color: #008080;">50</span>                 bytes[0] = (<span style="color: #0000ff;">byte</span>) (Integer.parseInt(strH, 16<span style="color: #000000;">));
</span><span style="color: #008080;">51</span>                 bytes[1] = (<span style="color: #0000ff;">byte</span>) (Integer.parseInt(strL, 16<span style="color: #000000;">));
</span><span style="color: #008080;">52</span> 
<span style="color: #008080;">53</span>                 firstWord = <span style="color: #0000ff;">new</span><span style="color: #000000;"> String(bytes);
</span><span style="color: #008080;">54</span>                 <span style="color: #0000ff;">break</span><span style="color: #000000;">;
</span><span style="color: #008080;">55</span>             <span style="color: #0000ff;">default</span><span style="color: #000000;">:
</span><span style="color: #008080;">56</span>                 tempInt = rand.nextInt(10) + 48<span style="color: #000000;">;
</span><span style="color: #008080;">57</span>                 firstWord = String.valueOf((<span style="color: #0000ff;">char</span><span style="color: #000000;">) tempInt);
</span><span style="color: #008080;">58</span>                 <span style="color: #0000ff;">break</span><span style="color: #000000;">;
</span><span style="color: #008080;">59</span> <span style="color: #000000;">            }
</span><span style="color: #008080;">60</span>             finalWord +=<span style="color: #000000;"> firstWord;
</span><span style="color: #008080;">61</span> <span style="color: #000000;">        }
</span><span style="color: #008080;">62</span>         <span style="color: #0000ff;">return</span><span style="color: #000000;"> finalWord;
</span><span style="color: #008080;">63</span> <span style="color: #000000;">    }
</span><span style="color: #008080;">64</span> }</pre>
</div>
<p>　　只需要在web.xml中将初始化参数由默认的文本实现类改成我们自己的实现类：</p>
<div class="cnblogs_code">
<pre><span style="color: #008080;">1</span> <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">init-param</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;">2</span>     <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">description</span><span style="color: #0000ff;">&gt;</span>文本实现类<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">description</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;">3</span>     <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">param-name</span><span style="color: #0000ff;">&gt;</span>kaptcha.textproducer.impl<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">param-name</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;">4</span>     <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">param-value</span><span style="color: #0000ff;">&gt;</span>ChineseTextCreator<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">param-value</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;">5</span> <span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">init-param</span><span style="color: #0000ff;">&gt;</span></pre>
</div>
<p><img src="https://images0.cnblogs.com/blog2015/698228/201505/211834526047918.jpg" alt="" /></p>
<h2>　　算式验证码</h2>
<p>实现步骤如下：</p>
<ul>
<li>获取随机的数值将结果相加</li>
<li>将计算公式写入到验证码图片</li>
<li>将相加的结果放入到session中</li>
</ul>
<p>因此，我们需要重写KaptchaServlet这个用于生成验证码的Servlet。</p>
<div class="cnblogs_code">
<pre><span style="color: #008080;"> 1</span> <span style="color: #0000ff;">public</span> <span style="color: #0000ff;">class</span> MyKaptchaServlet <span style="color: #0000ff;">extends</span> HttpServlet <span style="color: #0000ff;">implements</span><span style="color: #000000;"> Servlet{
</span><span style="color: #008080;"> 2</span>     
<span style="color: #008080;"> 3</span>     <span style="color: #0000ff;">private</span><span style="color: #000000;"> Properties props;
</span><span style="color: #008080;"> 4</span>     <span style="color: #0000ff;">private</span><span style="color: #000000;"> Producer kaptchaProducer;
</span><span style="color: #008080;"> 5</span>     <span style="color: #0000ff;">private</span><span style="color: #000000;"> String sessionKeyValue;
</span><span style="color: #008080;"> 6</span>     
<span style="color: #008080;"> 7</span>     <span style="color: #0000ff;">public</span><span style="color: #000000;"> MyKaptchaServlet() {
</span><span style="color: #008080;"> 8</span>          props = <span style="color: #0000ff;">new</span><span style="color: #000000;"> Properties();
</span><span style="color: #008080;"> 9</span>          kaptchaProducer = <span style="color: #0000ff;">null</span><span style="color: #000000;">;
</span><span style="color: #008080;">10</span>          sessionKeyValue = <span style="color: #0000ff;">null</span><span style="color: #000000;">;
</span><span style="color: #008080;">11</span> <span style="color: #000000;">    }
</span><span style="color: #008080;">12</span>     
<span style="color: #008080;">13</span>     <span style="color: #0000ff;">public</span> <span style="color: #0000ff;">void</span> init(ServletConfig conf) <span style="color: #0000ff;">throws</span><span style="color: #000000;"> ServletException {
</span><span style="color: #008080;">14</span>         <span style="color: #0000ff;">super</span><span style="color: #000000;">.init(conf);
</span><span style="color: #008080;">15</span> 
<span style="color: #008080;">16</span>         ImageIO.setUseCache(<span style="color: #0000ff;">false</span><span style="color: #000000;">);
</span><span style="color: #008080;">17</span> 
<span style="color: #008080;">18</span>         Enumeration initParams =<span style="color: #000000;"> conf.getInitParameterNames();
</span><span style="color: #008080;">19</span>         <span style="color: #0000ff;">while</span><span style="color: #000000;"> (initParams.hasMoreElements()) {
</span><span style="color: #008080;">20</span>             String key =<span style="color: #000000;"> (String) initParams.nextElement();
</span><span style="color: #008080;">21</span>             String value =<span style="color: #000000;"> conf.getInitParameter(key);
</span><span style="color: #008080;">22</span>             <span style="color: #0000ff;">this</span><span style="color: #000000;">.props.put(key, value);
</span><span style="color: #008080;">23</span> <span style="color: #000000;">        }
</span><span style="color: #008080;">24</span> 
<span style="color: #008080;">25</span>         Config config = <span style="color: #0000ff;">new</span> Config(<span style="color: #0000ff;">this</span><span style="color: #000000;">.props);
</span><span style="color: #008080;">26</span>         <span style="color: #0000ff;">this</span>.kaptchaProducer =<span style="color: #000000;"> config.getProducerImpl();
</span><span style="color: #008080;">27</span>         <span style="color: #0000ff;">this</span>.sessionKeyValue =<span style="color: #000000;"> config.getSessionKey();
</span><span style="color: #008080;">28</span> <span style="color: #000000;">    }
</span><span style="color: #008080;">29</span> 
<span style="color: #008080;">30</span>     <span style="color: #0000ff;">public</span> <span style="color: #0000ff;">void</span><span style="color: #000000;"> doGet(HttpServletRequest req, HttpServletResponse resp)
</span><span style="color: #008080;">31</span>             <span style="color: #0000ff;">throws</span><span style="color: #000000;"> ServletException, IOException {
</span><span style="color: #008080;">32</span>         resp.setDateHeader("Expires", 0L<span style="color: #000000;">);
</span><span style="color: #008080;">33</span> 
<span style="color: #008080;">34</span>         resp.setHeader("Cache-Control", "no-store, no-cache, must-revalidate"<span style="color: #000000;">);
</span><span style="color: #008080;">35</span> 
<span style="color: #008080;">36</span>         resp.addHeader("Cache-Control", "post-check=0, pre-check=0"<span style="color: #000000;">);
</span><span style="color: #008080;">37</span> 
<span style="color: #008080;">38</span>         resp.setHeader("Pragma", "no-cache"<span style="color: #000000;">);
</span><span style="color: #008080;">39</span> 
<span style="color: #008080;">40</span>         resp.setContentType("image/jpeg"<span style="color: #000000;">);
</span><span style="color: #008080;">41</span> 
<span style="color: #008080;">42</span>         String capText = <span style="color: #0000ff;">this</span><span style="color: #000000;">.kaptchaProducer.createText();
</span><span style="color: #008080;">43</span>         String s1 = capText.substring(0, 1);    <span style="color: #008000;">//</span><span style="color: #008000;"> 获取随机生成的第一个数字</span>
<span style="color: #008080;">44</span>         String s2 = capText.substring(1, 2);    <span style="color: #008000;">//</span><span style="color: #008000;"> 由于web.xml中配置的验证码字符都是数字，不会发生数字格式化异常</span>
<span style="color: #008080;">45</span>         <span style="color: #0000ff;">int</span> r = Integer.parseInt(s1) +<span style="color: #000000;"> Integer.parseInt(s2);
</span><span style="color: #008080;">46</span> 
<span style="color: #008080;">47</span>         req.getSession().setAttribute(<span style="color: #0000ff;">this</span>.sessionKeyValue, String.valueOf(r));    <span style="color: #008000;">//</span><span style="color: #008000;"> 将结果存入session</span>
<span style="color: #008080;">48</span> 
<span style="color: #008080;">49</span>         BufferedImage bi = <span style="color: #0000ff;">this</span>.kaptchaProducer.createImage(s1 + " + " + s2 + " = ?"); <span style="color: #008000;">//</span><span style="color: #008000;"> 产生图片</span>
<span style="color: #008080;">50</span> 
<span style="color: #008080;">51</span>         ServletOutputStream out =<span style="color: #000000;"> resp.getOutputStream();
</span><span style="color: #008080;">52</span> 
<span style="color: #008080;">53</span>         ImageIO.write(bi, "jpg"<span style="color: #000000;">, out);
</span><span style="color: #008080;">54</span>         <span style="color: #0000ff;">try</span><span style="color: #000000;"> {
</span><span style="color: #008080;">55</span> <span style="color: #000000;">            out.flush();
</span><span style="color: #008080;">56</span>         } <span style="color: #0000ff;">finally</span><span style="color: #000000;"> {
</span><span style="color: #008080;">57</span> <span style="color: #000000;">            out.close();
</span><span style="color: #008080;">58</span> <span style="color: #000000;">        }
</span><span style="color: #008080;">59</span> <span style="color: #000000;">    }
</span><span style="color: #008080;">60</span> 
<span style="color: #008080;">61</span> }</pre>
</div>
<p>　　在web.xml中有2点需要注意：</p>
<ol>
<li>验证码文本只能是0~9这10个数字；</li>
<li>验证码的长度是2（写多了也只会取出前2个随机数，写少了会抛出数字格式化异常）。</li>
</ol>
<div class="cnblogs_code">
<pre><span style="color: #008080;"> 1</span> <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">servlet-name</span><span style="color: #0000ff;">&gt;</span>Kcaptcha<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">servlet-name</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 2</span>     <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">servlet-class</span><span style="color: #0000ff;">&gt;</span>MyKaptchaServlet<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">servlet-class</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 3</span> <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">init-param</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 4</span>         <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">description</span><span style="color: #0000ff;">&gt;</span>文本集合<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">description</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 5</span>         <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">param-name</span><span style="color: #0000ff;">&gt;</span>kaptcha.textproducer.char.string<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">param-name</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 6</span>         <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">param-value</span><span style="color: #0000ff;">&gt;</span>0123456789<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">param-value</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 7</span>     <span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">init-param</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 8</span>     <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">init-param</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;"> 9</span>     <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">description</span><span style="color: #0000ff;">&gt;</span>验证码长度<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">description</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;">10</span>     <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">param-name</span><span style="color: #0000ff;">&gt;</span>kaptcha.textproducer.char.length<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">param-name</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;">11</span>     <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">param-value</span><span style="color: #0000ff;">&gt;</span>8<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">param-value</span><span style="color: #0000ff;">&gt;</span>
<span style="color: #008080;">12</span> <span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">init-param</span><span style="color: #0000ff;">&gt;</span></pre>
</div>
<p><img src="https://images0.cnblogs.com/blog2015/698228/201505/211933051826487.jpg" alt="" /></p></div><div id="MySignature"></div>
<div class="clear"></div>
<div id="blog_post_info_block">
<div id="BlogPostCategory"></div>
<div id="EntryTag"></div>
<div id="blog_post_info">
</div>
<div class="clear"></div>
<div id="post_next_prev"></div>
</div>


		</div>
		<div class = "postDesc">posted @ <span id="post-date">2015-05-21 19:34</span> <a href='http://www.cnblogs.com/happyfans/'>夜已殇</a> 阅读(<span id="post_view_count">...</span>) 评论(<span id="post_comment_count">...</span>)  <a href ="https://i.cnblogs.com/EditPosts.aspx?postid=4486010" rel="nofollow">编辑</a> <a href="#" onclick="AddToWz(4486010);return false;">收藏</a></div>
	</div>
	<script type="text/javascript">var allowComments=true,cb_blogId=212385,cb_entryId=4486010,cb_blogApp=currentBlogApp,cb_blogUserGuid='0b5704e6-7977-e411-b908-9dcfd8948a71',cb_entryCreatedDate='2015/5/21 19:34:00';loadViewCount(cb_entryId);var cb_postType=1;</script>
	
</div><!--end: topics 文章、评论容器-->
</div><a name="!comments"></a><div id="blog-comments-placeholder"></div><script type="text/javascript">var commentManager = new blogCommentManager();commentManager.renderComments(0);</script>
<div id='comment_form' class='commentform'>
<a name='commentform'></a>
<div id='divCommentShow'></div>
<div id='comment_nav'><span id='span_refresh_tips'></span><a href='javascript:void(0);' onclick='return RefreshCommentList();' id='lnk_RefreshComments' runat='server' clientidmode='Static'>刷新评论</a><a href='#' onclick='return RefreshPage();'>刷新页面</a><a href='#top'>返回顶部</a></div>
<div id='comment_form_container'></div>
<div class='ad_text_commentbox' id='ad_text_under_commentbox'></div>
<div id='ad_t2'></div>
<div id='opt_under_post'></div>
<div id='cnblogs_c1' class='c_ad_block'></div>
<div id='under_post_news'></div>
<div id='cnblogs_c2' class='c_ad_block'></div>
<div id='under_post_kb'></div>
<div id='HistoryToday' class='c_ad_block'></div>
<script type='text/javascript'>
    fixPostBody();
    setTimeout(function () { incrementViewCount(cb_entryId); }, 50);
    deliverAdT2();
    deliverAdC1();
    deliverAdC2();    
    loadNewsAndKb();
    loadBlogSignature();
    LoadPostInfoBlock(cb_blogId, cb_entryId, cb_blogApp, cb_blogUserGuid);
    GetPrevNextPost(cb_entryId, cb_blogId, cb_entryCreatedDate, cb_postType);
    loadOptUnderPost();
    GetHistoryToday(cb_blogId, cb_blogApp, cb_entryCreatedDate);   
</script>
</div>


	</div><!--end: forFlow -->
	</div><!--end: mainContent 主体内容容器-->

	<div id="sideBar">
		<div id="sideBarMain">
			
<!--done-->
<div class="newsItem">
<h3 class="catListTitle">公告</h3>
	<div id="blog-news"></div><script type="text/javascript">loadBlogNews();</script>
</div>

			<div id="blog-calendar" style="display:none"></div><script type="text/javascript">loadBlogDefaultCalendar();</script>
			
			<div id="leftcontentcontainer">
				<div id="blog-sidecolumn"></div><script type="text/javascript">loadBlogSideColumn();</script>
			</div>
			
		</div><!--end: sideBarMain -->
	</div><!--end: sideBar 侧边栏容器 -->
	<div class="clear"></div>
	</div><!--end: main -->
	<div class="clear"></div>
	<div id="footer">
		
<!--done-->
Copyright &copy;2018 夜已殇
	</div><!--end: footer -->
</div><!--end: home 自定义的最大容器 -->
</body>
</html>
