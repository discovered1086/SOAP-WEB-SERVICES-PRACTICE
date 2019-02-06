/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


function doSubmit(theForm,subfunctionality)
{
    if(subfunctionality!=null)
        {
            theForm.subfunctionality.value=subfunctionality;
        }
    theForm.submit();
}



