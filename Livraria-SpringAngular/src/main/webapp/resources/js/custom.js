$(document).ready(function() {
	$('.ano').mask('9999');

	$(".dropdown-button").dropdown();
});

function showModal(id) {
	$('#' + id).openModal();
}