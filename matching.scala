object matching {
    abstract class Notification
    case class Email(sender:String, title: String, body: String) extends Notification
    case class SMS(caller: String, message: String) extends Notification

    def main(args: Array[String]) {
        val email = Email("test@test.com", "From your father", "Come back home !!")
        val sms = SMS("123456789", "Come here !!")
        println(showNotification(email))
        println(showNotification(sms))
    }

    def showNotification(notification: Notification): String = {
        notification match {
            case Email(emailAdd, title, body) => s"you got an email from $emailAdd with title $title"
            case SMS(caller, message) => s"You got an SMS from $caller with message $message"
        }
    }
}