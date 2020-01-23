(function ($) {
    'use strict';
    /*==================================================================
        [ Daterangepicker ]*/
    
    
    try {
    
        $('#input-start').daterangepicker({
            ranges: true,
            autoApply: true,
            applyButtonClasses: false,
            autoUpdateInput: false
        },function (start, end) {
            $('#input-start').val(start.format('MM/DD/YYYY'));
            $('#input-end').val(end.format('MM/DD/YYYY'));
        });
    
    
    } catch(er) {console.log(er);}
    /*==================================================================
        [ Input Number (debugage :'(  ) ]*/
    
    try {
    
        var inputCon = $('.js-number-input');
    
        inputCon.each(function () {
            var that = $(this);
    
            var btnPlus = that.find('.plus');
            var btnMinus = that.find('.minus');
            var qtyInput = that.find('.quantity');
    
    
            btnPlus.on('click', function () {
                var max = 4;
                
                var oldValue = parseInt(qtyInput.val());
                if (oldValue >= max) {
                    var newVal = oldValue;
                } else {
                    var newVal = oldValue + 1;
                }
                
                qtyInput.val(refineString(newVal));
            });
    
            btnMinus.on('click', function () {
                var min = 1;
    
                var oldValue = parseInt(qtyInput.val());
                if (oldValue <= min) {
                    var newVal = oldValue;
                } else {
                    var newVal = oldValue - 1;
                }
                qtyInput.val(refineString(newVal));
            });
        });
    
        function refineString(s) {
            if(parseInt(s) == 1) return parseInt(s) + " Personne";
            else return parseInt(s) + " Personnes";
        }
    
    }catch (e) {
        console.log(e);
    }

 /*==================================================================
        [ Input prix (debugage :'(  ) ]*/

    try {
    
        var inputCon = $('.js-prix-input');
    
        inputCon.each(function () {
            var that = $(this);
    
            var btnPlus = that.find('.plus');
            var btnMinus = that.find('.minus');
            var qtyInput = that.find('.montant');
    
    
            btnPlus.on('click', function () {
                var max = 500;
                
                var oldValue = parseInt(qtyInput.val());
                if (oldValue >= max) {
                    var newVal = oldValue;
                } else {
                    var newVal = oldValue + 50;
                }
                
                qtyInput.val(refineString(newVal));
            });
    
            btnMinus.on('click', function () {
                var min = 50;
    
                var oldValue = parseInt(qtyInput.val());
                if (oldValue <= min) {
                    var newVal = oldValue;
                } else {
                    var newVal = oldValue - 50;
                }
                qtyInput.val(refineString(newVal));
            });
        });
    
        function refineString(s) {
            if(parseInt(s) == 1) return parseInt(s) + " Dhs";
            else return parseInt(s) + " Dhs";
        }
    
    }catch (e) {
        console.log(e);
    }

})(jQuery);