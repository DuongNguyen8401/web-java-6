app.controller("product-ctrl", function($scope, $http) {
	$scope.items = [];
	$scope.cates = [];
	$scope.form = {};

	$scope.initialize = function() {

		$http.get("/rest/products").then(resp => {
			$scope.items = resp.data;
			$scope.items.forEach(item => {
				item.createDate = new Date(item.createDate)
			})
		});

		$http.get("/rest/categories").then(resp => {
			$scope.cates = resp.data;
		});
	}

	$scope.initialize();

	$scope.reset = function() {
		$scope.form = {
			createDate: new Date(),
			image: 'cloud-upload.jpg',
			available: true,

		}
	}

	$scope.edit = function(item) {
		$scope.form = angular.copy(item);
		$(".nav-tabs a:eq(0)").tab('show')
	}

	$scope.create = function() {
		var item = angular.copy($scope.form);
		$http.post('/rest/products', item).then(resp => {
			resp.data.createDate = new Date(resp.data.createDate)
			$scope.items.push(resp.data);
			$scope.reset();
			alert("Create Product success");
		}).catch(error => {
			alert("Create product failse");
			console.log("error:", error);
		});
	}

	$scope.update = function() {
		var item = angular.copy($scope.form);

		$http.put(`/rest/products/${item.id}`, item).then(resp => {
			var index = $scope.items.findIndex(p => p.id == item.id);
			$scope.items[index] = item;
			alert("Update product success");
		}).catch(error => {
			alert("Update product failse");
			console.log("error:", error);
		})
	}

	$scope.delete = function(item) {
		var txt;
		var r = confirm("Do you want to delete this product?");
		if (r == true) {
			$http.delete(`/rest/products/${item.id}`, item).then(resp => {
				var index = $scope.items.findIndex(p => p.id == item.id);
				$scope.items.splice(index, 1);
				$scope.reset();
				alert("delete product success");
			}).catch(error => {
				alert("delete product failse");
				console.log("error:", error);
			})
		} else {

		}


	}

	$scope.imageChanged = function(files) {
		var data = new FormData();
		data.append('file', files[0]);
		console.log(files)
		$http.post('/rest/upload/images', data, {
			transformRequest: angular.identity,
			headers: { 'Content-Type': undefined }
		}).then(resp => {
			$scope.form.image = resp.data.name;
			alert("Upload Image Success");
		}).catch(error => {
			alert("Upload Image False");
			console.log("Error", error);
		})


	}


	$scope.pager = {
		page: 0,
		size: 10,
		get items() {
			var start = this.page * this.size;
			return $scope.items.slice(start, start + this.size);
		},
		get count() {
			return Math.ceil(1.0 * $scope.items.length / this.size);
		},
		first() {
			this.page = 0;
		},
		prev() {
			this.page--;
			if (this.page < 0) {
				this.last();
			}
		},
		next() {
			this.page++;
			if (this.page >= this.count) {
				this.first();
			}
		},
		last() {
			this.page = this.count - 1;
		}
	}
});