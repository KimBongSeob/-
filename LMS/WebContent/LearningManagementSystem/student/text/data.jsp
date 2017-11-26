<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<select class="form-control" name="Register_option1"
	id="Register_option1-1">
	<option>선택</option>
	<option value="휴학" data-target="#Register_option_button1">휴학</option>
	<option value="복학" data-target="#Register_option_button1">복학</option>
	<option value="휴학연장" data-target="#Register_option_button1">휴학연장</option>
</select>


<input type="button" class="btn btn-lg bg-aqua" name="Register_option3"
	id="Register_option_button1" value="조회하기">
	
<div class="col-lg-12" style="float: right;">

<input type="submit" class="btn btn-lg bg-aqua" name="Register_option4"
	id="Register_option_button2" value="신청하기">
</div>
<div id="Register_optionList">
	<div class="info-box">
		<span class="info-box-icon bg-aqua">학기선택</span>
		<div class="info-box-content">
			<div class="info-box-text col-lg-4">
				<select class="form-control" name="Register_option_details"
					id="Register_option2-1">
					<option value="선택">선택</option>
					<option value="1">1학기</option>
					<option value="2">2학기</option>
					<option value="3">3학기</option>
					<option value="4">4학기</option>
					<option value="5">5학기</option>
					<option value="6">6학기</option>
				</select>
			</div>
			<div class="col-lg-6" >
				<input type="submit" class="btn btn-lg bg-aqua"
					name="Register_option4" id="Register_option_button3" value="신청하기">
			</div>
		</div>
	</div>
</div>