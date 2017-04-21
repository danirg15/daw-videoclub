$(function() {/** Stars **/
	let enableStar = function($ele, isHalf) {
		if(!isHalf) {
			$ele.toggleClass("fa-star", true).toggleClass("fa-star-half-o fa-star-o", false);
		} else {
			$ele.toggleClass("fa-star-half-o", true).toggleClass("fa-star fa-star-o", false);
		}
	}

	let disableStar = function($ele) {
		$ele.toggleClass("fa-star-o", true).toggleClass("fa-star fa-star-half-o", false);
	}

	$(".star-group").on("mouseleave", function() {
		// Apply existing range
		let rankn = $(this).data("rank");
		$("i.fa").each(function() {
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

	$starList = $(".fa-star, .fa-star-half-o, .fa-star-o");
	$starList.on("mousemove", function(e) {
		let $this = $(this);
		let isHalf = (e.pageX - this.offsetLeft) < $this.width() / 2;

		enableStar($this, isHalf);
		$this.prevAll().each(function() { enableStar($(this), false); });
		$this.nextAll().each(function() { disableStar($(this)); });
	});

	$starList.on("click", function(e) {
		let $this = $(this);
		let nrank = $this.data("star");
		if((e.pageX - this.offsetLeft) < $this.width() / 2) {
			nrank += 0.5;
		}
		console.log(nrank);

		$this.parent().data("rank", nrank)
	})
});