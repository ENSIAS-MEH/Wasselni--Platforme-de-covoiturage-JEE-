'use strict';

var InputFile = function() {
  if (arguments[0] && typeof arguments[0] === 'object') {
    this.options = arguments[0];
  }

  var fields = document.querySelectorAll('input[type="file"]');
  for (var i = 0; i < fields.length; i++) {
    this.createField(fields[i]);
  }
};

InputFile.prototype.createField = function(field) {
  var options = this.options || {};

  var dropArea = document.createElement('div');
  dropArea.className = 'inf__drop-area';
  field.parentNode.insertBefore(dropArea, field);
  dropArea.appendChild(field);

  var btn = document.createElement('span');
  btn.className = 'inf__btn';
  btn.innerText = options.buttonText || 'Selectionner une image';
  dropArea.insertBefore(btn, field);

  var hint = document.createElement('span');
  hint.className = 'inf__hint';
  hint.innerText = options.hint || 'glisser-déposer';
  dropArea.insertBefore(hint, field);

  addMultiEventListener(field, 'dragenter click focus', function() {
    dropArea.classList.add('is-active');
  });

  addMultiEventListener(field, 'dragleave drop blur', function() {
    dropArea.classList.remove('is-active');
  });

  field.addEventListener('change', function() {
    var filesCount = field.files.length;
    if (filesCount === 1) {
      hint.innerText = field.value.split('\\').pop();
    } else {
      hint.innerText = filesCount + ' ' + (options.message || 'files chosen');
    }
  });
};

function addMultiEventListener(el, e, fn) {
  var events = e.split(' ');
  for (var i = 0; i < events.length; i++) {
    el.addEventListener(events[i], fn, false);
  }
}