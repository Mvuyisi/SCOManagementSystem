package scomanagementsystem.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import scomanagementsystem.Model.MeetingResource;
import scomanagementsystem.domain.Meetings;
import scomanagementsystem.services.MeetingsService;

/**
 * Created by student on 2015/09/13.
 */
public class MeetingsPage {
    @Autowired
    private MeetingsService meetingsService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String Index()
    {
        return "meetings details";
    }

    @RequestMapping(value = "/{meetingNo}", method = RequestMethod.GET)
    public MeetingResource getMeetings(@PathVariable Integer meetingNo)
    {
        MeetingResource hateoas;
        Meetings meetings = meetingsService.getMeeting(meetingNo);

        MeetingResource res = new MeetingResource
                .Builder(meetings.getMeetingNo())
                .meetingDate("12 April 15")
                .meetingName("AGM")
                .build();

        Link meetingsDetails = new
                Link("http://localhost:8080/api/meetings/" + res.getMeetingNo().toString())
                .withRel("meetings");

        res.add(meetingsDetails);
        hateoas = res;

        return hateoas;
    }
}
