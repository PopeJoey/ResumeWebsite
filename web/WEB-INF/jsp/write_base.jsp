<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <jsp:include page="include/common_import.jsp" />
	<script>
        var Select = {
        del : function(obj,e){
        if((e.keyCode||e.which||e.charCode) == 8){
        var opt = obj.options[0];
        opt.text = opt.value = opt.value.substring(0, opt.value.length>0?opt.value.length-1:0);
        }
        },
        write : function(obj,e){
        if((e.keyCode||e.which||e.charCode) == 8)return ;
        var opt = obj.options[0];
        opt.selected = "selected";
        opt.text = opt.value += String.fromCharCode(e.charCode||e.which||e.keyCode);
        }
        }
	</script>
</head>

    <jsp:include page="include/header.jsp" />

    <div class="about">
        <div class="container">
            <section class="title-section">
                <h1 class="title-header">第一步</h1>
            </section>
        </div>
    </div>
    <div class="contact">
        <div class="container">
            <div class="contact_bottom">
                <form method="post" action="contact-post.html">
                    <div class="contact-to">
                        <input type="text" class="text" value="Name" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = 'Name';}">
                        <input type="text" class="text" value="Gender" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = 'Email';}" style="margin-left: 10px">
                        <input type="text" class="text" value="Age" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = 'Subject';}" style="margin-left: 10px">
                    </div>
                    <div class="contact-to">
                        <input type="text" class="text" value="Address" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = 'Address';}">
                        <input type="text" class="text" value="Phone Number" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = 'Phone Name';}" style="margin-left: 10px">
                        <select class="form-control" onkeydown="Select.del(this,event)" onkeypress="Select.write(this,event)" >
						<option></option>
						<option>457067940@qq.com</option>
						</select>
                    </div>
                    <div class="text2">
                        <textarea value="Self-instroduction:" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = 'Brief self-instroduction';}">Brief self-instroduction</textarea>
                    </div>
                    <div> <a href="./2" class="submit">下一步</a> </div>
                </form>
            </div>
        </div>
    </div>

<jsp:include page="include/footer.jsp" />

    </body>
</html>
