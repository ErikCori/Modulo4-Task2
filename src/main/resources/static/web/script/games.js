var url = "http://localhost:8080/api/games"

var app = new Vue({
    el:'#app',
    data:{
        games:[],
    }
})
fetch(url)
.then(function(myData){
    return myData.json();
})
.then(function(myData){
    data = myData;
    app.games = data;
})