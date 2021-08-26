axios.get('localhost/api/books')
  .then(function (response) {
    console.log(response[0]);
  })