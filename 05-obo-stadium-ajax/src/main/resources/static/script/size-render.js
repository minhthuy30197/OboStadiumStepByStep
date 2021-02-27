function sizeGuideRender() {
  let sizeVn = [35, 36, 37, 38, 39, 40, 41, 42];

  let sizeUs = [2.5, 3.5, 4.5, 5.5, 6.5, 7.5, 8.5, 9.5];

  let sizeCm = [21.3, 22.2, 23, 23.8, 24.6, 25.4, 26.2, 27.1];
  let tr = '';
  for (let i = 0; i < sizeVn.length; i++) {
    tr += `
    <tr>
      <td>${sizeVn[i]}</td>
      <td>${sizeUs[i]}</td>
      <td>${sizeCm[i]}</td>
    </tr>
    `;
  }
  $('.side-guide-table tbody').html(tr);
}