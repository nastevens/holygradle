# Gets window in browser, global scope in node
root = exports ? this
apiPrefix = "api/v1/"

root.getLanguages = ->
    $.getJSON apiPrefix + "languages", (languages) ->
        listItems = for language in languages
            "<li>" + language.name + "</li>"
        $("<ul/>", {
            class: "language-list",
            html: listItems.join("")
        }).appendTo("body")