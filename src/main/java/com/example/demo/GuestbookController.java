package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/guestbook")
public class GuestbookController {

    private final GuestbookRepository guestbookRepository;

    // 생성자 주입
    public GuestbookController(GuestbookRepository guestbookRepository) {
        this.guestbookRepository = guestbookRepository;
    }

    // 1. 목록 페이지
    @GetMapping("")
    public String list(Model model) {
        List<Guestbook> list = guestbookRepository.findAllByOrderByIdDesc();
        model.addAttribute("list", list);
        return "list";
    }

    // 2. 작성 폼 페이지
    @GetMapping("/write")
    public String writeForm() {
        return "write";
    }

    // 3. 저장
    @PostMapping("/write")
    public String save(@RequestParam String author, @RequestParam String content) {
        Guestbook guestbook = new Guestbook();
        guestbook.setAuthor(author);
        guestbook.setContent(content);
        guestbook.setCreatedAt(LocalDateTime.now());

        guestbookRepository.save(guestbook);
        return "redirect:/guestbook";
    }

    // 4. 삭제
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        guestbookRepository.deleteById(id);
        return "redirect:/guestbook";
    }
}
