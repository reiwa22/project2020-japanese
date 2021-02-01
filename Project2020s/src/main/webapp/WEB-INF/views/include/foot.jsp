<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   

<style>
#manager{
	color: green;
}
</style>

    <footer class="site-footer border-top">
      <div class="container">
        <div class="row">
          <div class="col-lg-6 mb-5 mb-lg-0">
            <div class="row">
              <div class="col-md-12">
                <h3 class="footer-heading mb-4">みどり本屋</h3>
              </div>
              <div class="col-md-6 col-lg-4">
                <ul class="list-unstyled">
                </ul>
              </div>
              <div class="col-md-6 col-lg-4">
                <ul class="list-unstyled">
                </ul>
              </div>
              <div class="col-md-6 col-lg-4">
                <ul class="list-unstyled">
                </ul>
              </div>
            </div>
          </div>
          <div class="col-md-6 col-lg-3 mb-4 mb-lg-0">
            <h3 class="footer-heading mb-4">すべての書籍は著作権によって保護されます。 無断コピー、スキャンはご遠慮ください。</h3>
            <a href="#" class="block-6">
              <img src="../../resources/images/footer.png" alt="Image placeholder" class="img-fluid rounded mb-4">
              <h3 class="font-weight-light  mb-0">様々な国内書籍と海外書籍を同時にご覧いただけます。</h3>
              <p>営業時間は午前9時から午後10時までです。</p>
            </a>
          </div>
          <div class="col-md-6 col-lg-3">
            <div class="block-5 mb-5">
              <h3 class="footer-heading mb-4">住所</h3>
              <ul class="list-unstyled">
                <li class="address">東京都三鷹市北野千川</li>
                <li class="phone"><a href="tel://02-1234-1234">080-1234-1234</a></li>
                <li class="email">hermesmin@gmail.com</li>
              </ul>
            </div>

            <div class="block-7">
              <form action="#" method="post">
                <label for="email_subscribe" class="footer-heading"></label>
                <div class="form-group">
               <a href="/jm/jm_contact" class="btn btn-danger" style="height: 40px; width: 130px">お問い合わせ</a>
            </div>
                 <c:choose>
                  	<c:when test="${sessionScope.u_grade =='gold'}">
                  		<li><a href="/jmManager/jm_manager" id="manager">管理者ページ</a></li>
                  	</c:when>
                  </c:choose>
              </form>
            </div>
          </div>
        </div>
        <div class="row pt-5 mt-5 text-center">
          <div class="col-md-12">
          </div>
          
        </div>
      </div>
    </footer>
  </div>

  <script src="../../resources/js/jquery-3.3.1.min.js"></script>
  <script src="../../resources/js/jquery-ui.js"></script>
  <script src="../../resources/js/popper.min.js"></script>
  <script src="../../resources/js/bootstrap.min.js"></script>
  <script src="../../resources/js/owl.carousel.min.js"></script>
  <script src="../../resources/js/jquery.magnific-popup.min.js"></script>
  <script src="../../resources/js/aos.js"></script>

  <script src="../../resources/js/main.js"></script>
    
  </body>
</html>