#include <ae\ae.h>
#include <tccore\custom.h>
#include <tccore\aom.h>
#include <tccore\tctype.h>
#include <tccore\aom_prop.h>
#include <tc\emh.h>
#include <epm\epm.h>
#include <epm\epm_task_template_itk.h>
#include <ict\ict_userservice.h>
#include <tc\tc.h>
#include <tccore\tctype.h>
#include <server_exits\user_server_exits.h>
#include <tccore\item_msg.h>
#include <tccore\tc_msg.h>
#include <ae\dataset_msg.h>
#include <user_exits\user_exits.h>
#include <sa\group.h>
#include <string.h>

int EPM_update_property( EPM_action_message_t);

 extern DLLAPI int update_property_register_callbacks()
   {
        int ret_code = EPM_register_action_handler( "update_property","Updates the custom property Approved group in the workflow",EPM_update_property);
		if(ret_code==ITK_ok){
			printf("Registered Successfully \n");
		}
		return ret_code;
   }

int EPM_update_property(EPM_action_message_t msg)
{
 int ret_code = ITK_ok;
 
//EPM_ask_attachments variable declarations
tag_t  root_task=NULLTAG;
int count=0;
tag_t**  attachments = NULL;
 
//Pick up the root task from the work flow
ret_code = EPM_ask_root_task(msg.task,&root_task);
printf("\n The ret_code status is %d:", ret_code);
if(ret_code == ITK_ok)
{
 printf("Root task success \n");
}
else
{
printf("Root task failure \n");
}
//Get the attachments from the root task
ret_code = EPM_ask_attachments(root_task,EPM_target_attachment,&count,&attachments);
printf("\n The ret_code status is %d:",ret_code);
if(ret_code == ITK_ok)
{
	printf("\nThe count of attachments is : %d",count);
	printf("\n EPM_ask_attachments success");
} 
else
{
	printf("\n EPM_ask_attachments failure");
}
//refresh the AOM property and unlock the property for modification
ret_code = AOM_refresh(attachments[0],1);
printf("\n The ret_code status is %d:",ret_code);
if(ret_code == ITK_ok)
{
 printf("\n AOM_refresh success");
}
else
{
 printf("\n AOM_refresh failure");
}


//Set the value of the custom property 
ret_code = AOM_set_value_string(attachments[0],"a5_approver_group","Team center power plm approver group");
printf("\n The ret_code status is %d:",ret_code);
if(ret_code == ITK_ok)
{
   printf("\n AOM_set_value_string is success");
} 
else
{
	printf("\n AOM_set_value_string is failure");
}

//saves the property to the database
ret_code = AOM_save(&attachments[0]);
printf("\n The ret_code status is %d:",ret_code);
if(ret_code == ITK_ok)
{
   printf("\n AOM_save is success");
} 
else
{
	printf("\n AOM_save is failure");
}
return ret_code;
}
