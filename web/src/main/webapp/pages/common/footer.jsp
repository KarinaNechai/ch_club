<jsp:root xmlns="http://www.w3.org/1999/xhtml"
          xmlns:jsp="http://java.sun.com/JSP/Page"
          xmlns:spring="http://www.springframework.org/tags"
          version="2.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://www.springframework.org/tags ">
    <footer class="newFooter">
        <div id="footer" class="footer">
            <h2> Copyright В© 2020 www.club_sova.by</h2>
            <a href="${requestScope['javax.servlet.forward.request_uri']}?locale=ru" style="padding: 5px">RU</a>
            <a href="${requestScope['javax.servlet.forward.request_uri']}?locale=en" style="padding: 5px">EN</a>
        </div>
    </footer>

</jsp:root>
