$(window).resize(changeUi);

$(function () {
  changeUi();
  pagination();
});

function changeUi() {
  $(".nav-link#news").addClass('active-nav');
}

function pagination() {
  $('.news-wrapper').paginate({
    scope: $('.news'),
    perPage: 5,
    containerTag: 'nav',
    paginationTag: 'ul',
    itemTag: 'li',
    linkTag: 'a',
  });
}