// ViewModel
function AppViewModel() {
    var self = this;

    self.resumes = ko.observableArray([]);
    self.searchText = ko.observable();
    self.searching = ko.observable(false);

    self.searchResumes = function () {
        self.searching(true);
        $.getJSON("/resume/search?query=" + encodeURIComponent(self.searchText()), function(allData) {
            self.resumes(allData);
            self.searching(false);
        });

    };

    self.onKeyPress = function (d, evt) {
        if (evt.keyCode === 13) {
            self.searchResumes();
        }
        return true;
    };

    $.getJSON("/resume/all", function(allData) {
        self.resumes(allData);
    });
}

// Activates knockout.js
ko.applyBindings(new AppViewModel());