function requestDataUsers(url) {
    fetch(url)
        .then(data => data.json())
        .then(createRows )
}