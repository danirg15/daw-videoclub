"use strict";

$(function() {
	/** Stars **/
	let enableStar = function($ele, isHalf) {
		if(!isHalf) {
			$ele.toggleClass("fa-star", true).toggleClass("fa-star-half-o fa-star-o", false);
		} else {
			$ele.toggleClass("fa-star-half-o", true).toggleClass("fa-star fa-star-o", false);
		}
	};

	let disableStar = function($ele) {
		$ele.toggleClass("fa-star-o", true).toggleClass("fa-star fa-star-half-o", false);
	};

	$(".star-selectable").on("mouseleave", function() {
		// Apply existing range
		let $this = $(this);
		let rankn = $this.data("rank");
		$this.children("i.fa").each(function() {
			let $this = $(this);
			let n = $this.data("star");
			if(n == rankn - 0.5) {
				enableStar($this, true);
			} else if(n <= rankn) {
				enableStar($this, false);
			} else {
				disableStar($this);
			}
		});
	});

	let $starList = $(".star-selectable > .fa-star, .star-selectable > .fa-star-half-o, .star-selectable > .fa-star-o");
	$starList.on("mousemove", function(e) {
		let $this = $(this);
		let isHalf = (e.pageX - this.getBoundingClientRect().left) < $this.width() / 2;

		enableStar($this, isHalf);
		$this.prevAll().each(function() { enableStar($(this), false); });
		$this.nextAll().each(function() { disableStar($(this)); });
	});

	$starList.on("click", function(e) {
		let $this = $(this);
		let nrank = $this.data("star");
		if((e.pageX - this.getBoundingClientRect().left) < $this.width() / 2) {
			nrank += 0.5;
		}

		$this.parent().data("rank", nrank);

		// TODO: Subir rank al servidor
	});

    /**
	 * Search box
     */
    let $searchBox = $("#movie-search-name");
    $("#movie-search-go").on("click", function() {
		let searchName = $searchBox.val();
		if(!searchName) {
            alertify.error("Debes introducir un nombre de película a buscar");
        }
	});

    $searchBox.on("keyup", function(ev) {
		let movieName = $searchBox.val().trim();
		if(movieName) {
            $.ajax({
                url: "/movies/search",
                method: "GET",
                data: {partialTitle: movieName}
            }).done(function (reply) {
                $("#movie-list").html(reply);
            });
        }
	});
});