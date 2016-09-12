$(document).ready(function() {
	$('.ano').mask('9999');
});

function showModal(id) {
	$('#' + id).openModal();
}