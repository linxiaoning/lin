	 
var pages = ${page}; 
function ajaxpage(page) {
		alert("ajax");
		var page = page;
		$.ajax({
					type : "post",
					url : "customer_ajaxPaget.action",
					dataType : "json",
					data : 'page=' + page,			   				 
						$('#tableCustomer tr:not(:first)').remove();
						for ( var indexs in data.customerList) {
							var first_name = data.customerList[indexs].first_name;
							var last_name = data.customerList[indexs].last_name;
							var address = data.customerList[indexs].address_id.address_id;
							var email = data.customerList[indexs].email;
							var customer_id = data.customerList[indexs].customer_id;
							var last_update = data.customerList[indexs].last_update;
							var row = $("<tr><td><a href=\"Customer?parm=delete&Customer_id="
									+ customer_id
									+ "\">删除</a>|<a href=\"Customer?parm=update1&Customer_id="
									+ customer_id
									+ "\">修改</a></td>"
									+ "<td>"
									+ first_name
									+ "</td><td>"
									+ last_name
									+ "</td><td>"
									+ address
									+ "</td><td>"
									+ email
									+ "</td><td>"
									+ customer_id
									+ "</td><td>" + last_update + "</td></tr>");
							$("#tableCustomer").append(row)
						}
					}

				});
	} 