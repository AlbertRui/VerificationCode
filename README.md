
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8"/>
<meta name="viewport" content="width=device-width, initial-scale=1" />
</head>
<body>
<a name="top"></a>

<!--done-->
<div id="home">
<div id="main">
	<div id="mainContent">
	<div class="forFlow">
		
<div id="post_detail">
<!--done-->
<div id="topics">
	<div class = "post">
		<h1 class = "postTitle">
			Java实现验证码的制作
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
<h1>&nbsp;开源组件实现验证码</h1>
<p><img src="https://images0.cnblogs.com/blog2015/698228/201505/082211353456538.jpg" alt="" /></p>
<h2>　　Jcaptcha：</h2>
<p>　　一个用来生成图形验证码的开源组件，可以产生多种形式的验证码。可以与Spring组合使用。需要导入的jar包如下：</p>
<p><img src="https://images0.cnblogs.com/blog2015/698228/201505/202219064942839.jpg" alt="" /></p>
<P>	最终生成的验证码的效果如下：  </p>
<p>　　<img src="https://images0.cnblogs.com/blog2015/698228/201505/202230533546820.jpg" alt="" /></p>
<h2>　　kaptcha：</h2>
<p>　　它是可以配置的，也可以生成各种样式的验证码。如下是其生成效果：</p>
<p>　　<img src="https://images0.cnblogs.com/blog2015/698228/201505/211124161826846.jpg" alt="" />  <img src="https://images0.cnblogs.com/blog2015/698228/201505/211220024329477.jpg" alt="" /></p>
<h2>　　中文验证码</h2>
<p>　　查看前面的配置发现验证码字符的生成主要依靠的是kaptcha.textproducer.impl这个文本实现类，查看com.google.code.kaptcha.text.impl.DefaultTextCreator的源码，发现了它继承自&nbsp;Configurable并实现了TextProducer接口。我们可以仿照它自定义我们自己的验证码中的文本生成器：</p>
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
</body>
</html>