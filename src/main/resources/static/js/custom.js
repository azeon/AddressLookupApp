// get JSON 
function getJson() {
    try {
      return JSON.parse($('#json-input').val());
    } catch (ex) {
      alert('Wrong JSON Format: ' + ex);
    }
  }
  
  // initialize
  var editor = new JsonEditor('#json-display', getJson());
  
  // enable translate button
  $('#translate').on('click', function () {
    editor.load(getJson());
  });