import sys
import os
from PIL import Image, ImageDraw, ImageFont


cur_path = os.path.dirname(os.path.realpath('__file__'))
new_path = os.path.join(cur_path, 'printed_tickets/')


# file = open(new_path+"ticket_" + sys.argv[1], "w+")
# file.write(sys.argv[1])
# file.close()

ticket = Image.open("Ticket_template.png")
draw = ImageDraw.Draw(ticket)

# Event Name
draw.font = ImageFont.truetype("FreeMono.ttf", 25)
draw.text((125,95), sys.argv[2], fill="black")

# Section number
draw.font = ImageFont.truetype("FreeMono.ttf", 20)
draw.text((140,215), sys.argv[3], fill="black")

# Row number
draw.font = ImageFont.truetype("FreeMono.ttf", 20)
draw.text((107,265), sys.argv[4], fill="black")

# Seat number
draw.font = ImageFont.truetype("FreeMono.ttf", 20)
draw.text((112,315), sys.argv[5], fill="black")

# ticket_id
draw.font = ImageFont.truetype("FreeMono.ttf", 20)
draw.text((105,675), str(abs(hash(sys.argv[1]))) + '_' + sys.argv[1], fill="black")

# ticket.save(new_path + "ticket_" + sys.argv[1] + '.png')
ticket.show()
ticket.save(new_path + "ticket_" + sys.argv[1] + '.png')