function CutoffView() {
    this.years = new Set();
    this.grades = new Map();
    this.x = new Array();
    this.y = new Array();
    this.taken = new Array();
}

CutoffView.prototype.init = function() {
    this.years.clear();
    this.grades.clear();
    this.x = new Array();
    this.y = new Array();
    this.taken = new Array();
}

CutoffView.prototype.addCutoff = function(year, label, grade) {
    this.years.add(year);
    if (!this.grades.has(label)) {
        this.grades.set(label, new Map());
    }
    this.grades.get(label).set(year, grade);
}

CutoffView.prototype.generate = function() {

    var years = this.years;
    var grades = this.grades;
    var x = this.x;
    var y = this.y;
    var taken = this.taken;

    years.forEach(function (value, key, map) {
        x.push(key);
    })
    x.sort();
    var index = 0;
    grades.forEach(function (value, key, map) {
        y[index] = new Array();
        taken.push(key);
        for (var i = 0; i < x.length; i++) {
            if (value.has(x[i])) {
                y[index].push(value.get(x[i]));
            } else {
                y[index].push(null);
            }
        }
        index++;
    })

    console.log("inner:");
    console.log(y);
}