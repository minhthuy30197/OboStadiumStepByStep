$(window).resize(changeUi);

$(function () {
  changeUi();
  pagination(6,1,"/tin-tuc?page=");
});

function changeUi() {
  $(".nav-link#news").addClass('active-nav');
}

function pagination(totalPages, currentPage, link) {
  $('#pagination').pagination({
    pages: totalPages,
    currentPage: currentPage,
    cssStyle: '',
    prevText: '<span aria-hidden="true">&laquo;</span>',
    nextText: '<span aria-hidden="true">&raquo;</span>',
    onInit: function () {
        // fire first page loading
    },
    onPageClick: function (page, evt) {
        $('#pagination .active .current').addClass('page-link')
        $('#pagination .ellipse.clickable').addClass('page-link')
        $('#pagination .disabled .current.prev').addClass('page-link')
        $('#pagination .disabled .current.next').addClass('page-link')
        location.href = link+page
    }
  });

  $('#pagination .active .current').addClass('page-link')
  $('#pagination .ellipse.clickable').addClass('page-link')
  $('#pagination .disabled .current.prev').addClass('page-link')
  $('#pagination .disabled .current.next').addClass('page-link')
}