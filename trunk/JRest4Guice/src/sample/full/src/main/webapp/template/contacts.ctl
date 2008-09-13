<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>联系人管理(CTL template)</title>
<!-- 系统缺省的CSS -->
<link href="/full/css/default.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<br><br>
	<a href="/full/contact">添加新联系人</a>
	<br><br>
	$set{contacts=ctx.content} 
	<table id="contactTable" cellpadding="0" background="#ffffff" cellspacing="0" width="100%">
		<thead style="font-weight: bold;">
			<tr style="height: 26px;background-image: url('/full/images/head.jpg');color: white;">
				<td style="width: 110px;">&nbsp;姓 名</td>
				<td style="width: 110px;">&nbsp;移动电话</td>
				<td style="width: 130px;">&nbsp;电子邮件</td>
				<td>&nbsp;住址</td>
				<td style="width: 130px;">&nbsp;操作</td>
			</tr>
		</thead>
		<tbody>
		$for{contact : contacts}
			<tr style="cursor: pointer;height: 22px;">
				<td>&nbsp;<a href="contacts/${contact.id}">${contact.name}</a></td>
				<td>&nbsp;${contact.mobilePhone}</td>
				<td>&nbsp;${contact.email}</td>
				<td>&nbsp;${contact.address}</td>
				<td>&nbsp;<a href="contacts/${contact.id}!delete">删除</a></td>
			</tr>
		$end
		</tbody>
	</table>
	<br/>
	<div><img src="/full/images/go.gif" style="margin-bottom: -22px;margin-left: 0px;"><a href="/full/contactAjaxDemo.html" style="font-weight: bold;font-size: 20px;">返回体验AJAX版</a><a href="/full" style="font-weight: bold;font-size: 12px;margin-left:40px;">首  页</a></div>
</body>
</html>