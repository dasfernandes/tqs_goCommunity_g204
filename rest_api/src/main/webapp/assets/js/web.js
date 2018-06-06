/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
baseURL = "http://localhost:8080/rest_api";

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
        url: baseURL + "/rest/campaign/",
        success: function (data) {
            //colocar os dados no html conforme necessário
            alert(data)
        }
    });
}

function getCampaignInfo(iden) {
    $.ajax({
        method: "GET",
        url: baseURL + "/rest/campaign/" + String(iden),
        dataType: "JSON",
        headers: {
            Accept: "application/json;odata=verbose"
        },
        success: function (data) {
            //colocar os dados no html conforme necessário
            alert(data);
            document.getElementById("campaignName").innerHTML = data.title;
            document.getElementById("current").innerHTML = data.current;
            document.getElementById("goal").innerHTML = data.goal;
            document.getElementById("description").innerHTML = data.description;

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
        url: baseURL + "/rest/users/" + String(id),
        success: function (data) {
            //colocar os dados no html conforme necessário
            alert(data)
        }
    });
}
