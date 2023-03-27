import sys
import os
from PIL import Image, ImageDraw, ImageFont
import qrcode


cur_path = os.path.dirname(os.path.realpath('__file__'))
new_path = os.path.join(cur_path, 'printed_tickets/')


# file = open(new_path+"ticket_" + sys.argv[1], "w+")
# file.write(sys.argv[1])
# file.close()

ticket = Image.open("Ticket_template.png")
draw = ImageDraw.Draw(ticket)

# Event Name
draw.font = ImageFont.truetype("FreeMono.ttf", 25)
draw.text((130,222), sys.argv[2], fill="black")

# Section number
draw.font = ImageFont.truetype("FreeMono.ttf", 20)
draw.text((140,315), sys.argv[3], fill="black")

# Row number
draw.text((110,365), sys.argv[4], fill="black")

# Seat number
draw.text((110,415), sys.argv[5], fill="black")

# Date
draw.text((100,468), sys.argv[6], fill="black")

# ticket_id
draw.font = ImageFont.truetype("FreeMono.ttf", 20)
draw.text((105,675), str(abs(hash(sys.argv[1]))) + '_' + sys.argv[1], fill="black")


qr = qrcode.QRCode(version = 1,
                   box_size = 5,
                   border = 5)
 
# Adding data to the instance 'qr'
qr.add_data(str(abs(hash(sys.argv[1]))) + '_' + sys.argv[1])
 
qr.make(fit = True)
qr_image = qr.make_image(fill_color = 'black',
                    back_color = 'white')
 
qr_image.save('ticket_qrcode_' + sys.argv[1] + '.png')

qrimg = Image.open('ticket_qrcode_' + sys.argv[1] + '.png')

ticket.paste(qrimg, (170, 50))


# ticket.save(new_path + "ticket_" + sys.argv[1] + '.png')
ticket.show()
ticket.save(new_path + "ticket_" + sys.argv[1] + '.png')




