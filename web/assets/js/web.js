/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
baseURL = window.location.protocol + "//" + window.location.hostname + ":" + window.location.port

function login(email, password) {
    $.ajax({
        method: "POST",
        url: baseURL + "/rest/user/login",
        data: "{ \"email\": \"" + email + ", \"pw\": \!" + password + "\"}",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (data) {
            //codigo a executar se o login passar
            alert(data);
        },
        error: function () {
            //Codigo a executar se o login falhar
            alert("login falhou");
        }
    });
}

function register() {
    //todo
}

function getCampaigns() {
    $.ajax({
        method: "GET",
        url: baseURL + "/rest/campaigns/",
        success: function (data) {
            //colocar os dados no html conforme necessário
            alert(data)
        }
    });
}

function getCampaignInfo(iden) {
    $.ajax({
        method: "GET",
        url: baseURL + "/rest/campaigns/"+String(iden),
        dataType: "json",
        success: function (data) {
            //colocar os dados no html conforme necessário
            var dataObj = JSON.parse(data)
            for (var i = 0; i < dataObj.length; i++) {
              if (dataObj[i].id == iden) {
                document.getElementById("campaignName").innerHTML = dataObj[i].title
                document.getElementById("current").innerHTML = dataObj[i].current
                document.getElementById("goal").innerHTML = dataObj[i].goal
                document.getElementById("description").innerHTML = dataObj[i].description
              }
            }
            alert(data)
        }
    });
}

function getUsers() {
    $.ajax({
        method: "GET",
        url: baseURL + "/rest/users/",
        success: function (data) {
            var dataObj = JSON.parse(data)
            alert(data)
        }
    });
}

function getUserInfo(id) {
    $.ajax({
        method: "GET",
        url: baseURL + "/rest/users/"+String(id),
        success: function (data) {
            //colocar os dados no html conforme necessário
            alert(data)
        }
    });
}
