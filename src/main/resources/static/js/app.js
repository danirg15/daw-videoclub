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



	//Autocomplete
	$("#create-movie").on('blur', '#title', function ($e) {
		let title = $(this).val()

		if(title != '') {
			$.ajax({
				url: "/movies/autocomplete",
				method: "GET",
				data: {'title': title}
			}).done(function (reply) {

				if(reply != '') {
					let normalizedRating = ("" + ((Number(reply.vote_average) * 5.0) / 10.0)).replace(".", ",");
					$("#create-movie #title").val(reply.title);
					$("#create-movie #year").val(reply.release_date.split('-')[0]);
					$("#create-movie #plot").val(reply.overview);
					$("#create-movie #poster_url").val('https://image.tmdb.org/t/p/w500' + reply.poster_path);
					$("#create-movie #rating").val(normalizedRating);
					$("#create-movie #box_office").val(reply.revenue);

					let genres = [];
					reply.genres.forEach(function (genre) {
						genres.push(genre.name);
					});
					$("#create-movie #genres").val(genres.join(", "));
				}
			});//ajax

		}
	});

	// Password confirmation
    $("#password, #repeat-pwd").on("keyup", function() {
        var btn = $(this).parent().parent().find(":submit");
        if($("#password").val() != $("#repeat-pwd").val()) {
            btn.attr("disabled", "disabled");
            $("#repeat-pwd").parent().toggleClass("has-danger", true);
        } else {
            btn.removeAttr("disabled");
            $("#repeat-pwd").parent().toggleClass("has-danger", false);
        }
    });
});